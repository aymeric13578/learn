package se.aymeric.microservices.composite.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.aymeric.api.composite.course.*;
import se.aymeric.api.core.course.Course;
import se.aymeric.api.core.recommendation.Recommendation;
import se.aymeric.api.core.review.Review;
import se.aymeric.util.http.ServiceUtil;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseCompositeServiceImpl implements CourseCompositeService {

    private final ServiceUtil serviceUtil;
    private CourseCompositeIntegration integration;

    @Autowired
    public CourseCompositeServiceImpl(
            ServiceUtil serviceUtil, CourseCompositeIntegration integration) {

        this.serviceUtil = serviceUtil;
        this.integration = integration;
    }

    @Override
    public CourseAggregate getCourse(int courseId) {

        Course course = integration.getCourse(courseId);
        if (course == null) {
            throw new se.aymeric.api.exceptions.NotFoundException("No course found for courseId: " + courseId);
        }

        List<Recommendation> recommendations = integration.getRecommendations(courseId);

        List<Review> reviews = integration.getReviews(courseId);

        return createCourseAggregate(course, recommendations, reviews, serviceUtil.getServiceAddress());
    }

    private CourseAggregate createCourseAggregate(
            Course course,
            List<Recommendation> recommendations,
            List<Review> reviews,
            String serviceAddress) {

        // 1. Setup product info
        int courseId = course.getCourseId();
        String title = course.getTitle();
        String description = course.getDescription();
        String difficultyLevel = course.getDifficultyLevel();
        int popularityScore = course.getPopularityScore();
        double price = course.getPrice();

        // 2. Copy summary recommendation info, if available
        List<RecommendationSummary> recommendationSummaries =
                (recommendations == null) ? null : recommendations.stream()
                        .map(r -> new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()))
                        .collect(Collectors.toList());

        // 3. Copy summary review info, if available
        List<ReviewSummary> reviewSummaries =
                (reviews == null) ? null : reviews.stream()
                        .map(r -> new ReviewSummary(r.getReviewId(), r.getAuthor(), r.getSubject()))
                        .collect(Collectors.toList());

        // 4. Create info regarding the involved microservices addresses
        String courseAddress = course.getServiceAddress();
        String reviewAddress = (reviews != null && reviews.size() > 0) ? reviews.get(0).getServiceAddress() : "";
        String recommendationAddress = (recommendations != null && recommendations.size() > 0) ? recommendations.get(0).getServiceAddress() : "";
        ServiceAddresses serviceAddresses = new ServiceAddresses(serviceAddress, courseAddress, reviewAddress, recommendationAddress);

        return new CourseAggregate(courseId, title, description,price,popularityScore,difficultyLevel,
                recommendationSummaries, reviewSummaries, serviceAddresses);
    }
}


