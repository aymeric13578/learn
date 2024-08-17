package se.aymeric.microservices.composite.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import se.aymeric.api.core.recommendation.Recommendation;
import se.aymeric.api.core.review.Review;
import se.aymeric.microservices.composite.course.services.CourseCompositeIntegration;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CourseCompositeServiceApplicationTests {


	private static final int COURSE_ID_OK = 1;
	private static final int COURSE_ID_NOT_FOUND = 2;
	private static final int COURSE_ID_INVALID = 3;

	@Autowired
	private WebTestClient client;

	@MockBean
	private CourseCompositeIntegration compositeIntegration;

	@BeforeEach
	void setUp() {

		when(compositeIntegration.getCourse(COURSE_ID_OK))
				.thenReturn(new se.aymeric.api.core.course.Course(COURSE_ID_OK, "title","",1,1, "", "mock-address"));
		when(compositeIntegration.getRecommendations(COURSE_ID_OK))
				.thenReturn(singletonList(new Recommendation(COURSE_ID_OK, 1, "author", 1, "content", "mock address")));
		when(compositeIntegration.getReviews(COURSE_ID_OK))
				.thenReturn(singletonList(new Review(COURSE_ID_OK, 1, "author", "subject", "content", "mock address")));

		when(compositeIntegration.getCourse(COURSE_ID_NOT_FOUND))
				.thenThrow(new se.aymeric.api.exceptions.NotFoundException("NOT FOUND: " + COURSE_ID_NOT_FOUND));

		when(compositeIntegration.getCourse(COURSE_ID_INVALID))
				.thenThrow(new se.aymeric.api.exceptions.InvalidInputException("INVALID: " + COURSE_ID_INVALID));
	}

	@Test
	void contextLoads() {}

	@Test
	void getCourseById() {

		client.get()
				.uri("/course-composite/" + COURSE_ID_OK)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.courseId").isEqualTo(COURSE_ID_OK)
				.jsonPath("$.recommendations.length()").isEqualTo(1)
				.jsonPath("$.reviews.length()").isEqualTo(1);
	}

	@Test
	void getCourseNotFound() {

		client.get()
				.uri("/course-composite/" + COURSE_ID_NOT_FOUND)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/course-composite/" + COURSE_ID_NOT_FOUND)
				.jsonPath("$.message").isEqualTo("NOT FOUND: " + COURSE_ID_NOT_FOUND);
	}

	@Test
	void getCourseInvalidInput() {

		client.get()
				.uri("/course-composite/" + COURSE_ID_INVALID)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(UNPROCESSABLE_ENTITY)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/course-composite/" + COURSE_ID_INVALID)
				.jsonPath("$.message").isEqualTo("INVALID: " + COURSE_ID_INVALID);
	}

}
