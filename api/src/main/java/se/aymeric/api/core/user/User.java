package se.aymeric.api.core.user;

import se.aymeric.api.core.enrollment.Enrollment;
import se.aymeric.api.core.payment.Payment;
import se.aymeric.api.core.recommendation.Recommendation;
import se.aymeric.api.core.review.Review;

import java.util.List;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private List<Role> roles;
    private List<Enrollment> enrollments;
    private List<Payment> payments;
    private List<Review> reviews;
    private List<Recommendation> recommendations;

    // Constructors, getters, and setters
}
