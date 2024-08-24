package se.aymeric.api.core.payment;

import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private int userId; // Foreign Key to User
    private int courseId; // Foreign Key to Course
    private double amount;
    private LocalDateTime paymentDate;

    // Constructors, getters, and setters
}
