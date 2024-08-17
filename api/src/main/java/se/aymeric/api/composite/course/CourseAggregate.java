package se.aymeric.api.composite.course;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CourseAggregate {
    private  int courseId;
    private final String title;
    private String description;
    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private int popularityScore;
    private String difficultyLevel;

    //private final int weight;
    private final List<RecommendationSummary> recommendations;
    private final List<ReviewSummary> reviews;
    private final ServiceAddresses serviceAddresses;

    public CourseAggregate(
            int courseId,
            String title,
            String description,
            double price,
            int popularityScore,
            String difficultyLevel,
            List<RecommendationSummary> recommendations,
            List<ReviewSummary> reviews,
            ServiceAddresses serviceAddresses) {

        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.popularityScore = popularityScore;
        this.difficultyLevel = difficultyLevel;
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.serviceAddresses = serviceAddresses;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getPopularityScore() {
        return popularityScore;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public List<RecommendationSummary> getRecommendations() {
        return recommendations;
    }

    public List<ReviewSummary> getReviews() {
        return reviews;
    }

    public ServiceAddresses getServiceAddresses() {
        return serviceAddresses;
    }
}
