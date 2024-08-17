package se.aymeric.microservices.composite.course.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.aymeric.api.core.course.Course;
import se.aymeric.api.core.course.CourseService;
import se.aymeric.api.core.recommendation.Recommendation;
import se.aymeric.api.core.recommendation.RecommendationService;
import se.aymeric.api.core.review.Review;
import se.aymeric.api.core.review.ReviewService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import se.aymeric.api.exceptions.InvalidInputException;
import se.aymeric.api.exceptions.NotFoundException;
import se.aymeric.util.http.HttpErrorInfo;

import static org.springframework.http.HttpMethod.GET;

@Component
public class CourseCompositeIntegration implements CourseService, RecommendationService, ReviewService {

    private static final Logger LOG = LoggerFactory.getLogger(CourseCompositeIntegration.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String courseServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    @Autowired
    public CourseCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper mapper,
            @Value("${app.course-service.host}") String courseServiceHost,
            @Value("${app.course-service.port}") int courseServicePort,
            @Value("${app.recommendation-service.host}") String recommendationServiceHost,
            @Value("${app.recommendation-service.port}") int recommendationServicePort,
            @Value("${app.review-service.host}") String reviewServiceHost,
            @Value("${app.review-service.port}") int reviewServicePort) {

        this.restTemplate = restTemplate;
        this.mapper = mapper;

        courseServiceUrl = "http://" + courseServiceHost + ":" + courseServicePort + "/course/";
        recommendationServiceUrl = "http://" + recommendationServiceHost + ":" + recommendationServicePort + "/recommendation?courseId=";
        reviewServiceUrl = "http://" + reviewServiceHost + ":" + reviewServicePort + "/review?courseId=";
    }

    public Course getCourse(int courseId) {

        try {
            String url = courseServiceUrl + courseId;
            LOG.debug("Will call getCourse API on URL: {}", url);

            Course course = restTemplate.getForObject(url, Course.class);
            LOG.debug("Found a course with id: {}", course.getCourseId());

            return course;

        } catch (HttpClientErrorException ex) {

            switch (HttpStatus.resolve(ex.getStatusCode().value())) {
                case NOT_FOUND:
                    throw new NotFoundException(getErrorMessage(ex));

                case UNPROCESSABLE_ENTITY:
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    LOG.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        } catch (IOException ioex) {
            return ex.getMessage();
        }
    }

    public List<Recommendation> getRecommendations(int courseId) {

        try {
            String url = recommendationServiceUrl + courseId;

            LOG.debug("Will call getRecommendations API on URL: {}", url);
            List<Recommendation> recommendations = restTemplate
                    .exchange(url, GET, null, new ParameterizedTypeReference<List<Recommendation>>() {})
                    .getBody();

            LOG.debug("Found {} recommendations for a course with id: {}", recommendations.size(), courseId);
            return recommendations;

        } catch (Exception ex) {
            LOG.warn("Got an exception while requesting recommendations, return zero recommendations: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Review> getReviews(int courseId) {

        try {
            String url = reviewServiceUrl + courseId;

            LOG.debug("Will call getReviews API on URL: {}", url);
            List<Review> reviews = restTemplate
                    .exchange(url, GET, null, new ParameterizedTypeReference<List<Review>>() {})
                    .getBody();

            LOG.debug("Found {} reviews for a course with id: {}", reviews.size(), courseId);
            return reviews;

        } catch (Exception ex) {
            LOG.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }
}


