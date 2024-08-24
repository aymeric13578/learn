package se.aymeric.api.composite.user;

import se.aymeric.api.composite.course.ServiceAddresses;

import java.time.LocalDateTime;
import java.util.List;

/*Aggregates data from User-Service, Enrollment-Service, Payment-Service, Review-Service, and Recommendation-Service.
 */
public class UserAggregate {
    private final int userId;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private final List<EnrollmentSummary> enrollments;
    private final List<ReviewSummary> reviews;
    private final List<RecommendationSummary> recommendations;
    private final ServiceAddresses serviceAddresses;

    public UserAggregate(
            int userId,
            String username,
            String email,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            List<EnrollmentSummary> enrollments,
            List<ReviewSummary> reviews,
            List<RecommendationSummary> recommendations,
            ServiceAddresses serviceAddresses) {

        this.userId = userId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.enrollments = enrollments;
        this.reviews = reviews;
        this.recommendations = recommendations;
        this.serviceAddresses = serviceAddresses;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public List<EnrollmentSummary> getEnrollments() { return enrollments; }
    public List<ReviewSummary> getReviews() { return reviews; }
    public List<RecommendationSummary> getRecommendations() { return recommendations; }
    public ServiceAddresses getServiceAddresses() { return serviceAddresses; }
}
