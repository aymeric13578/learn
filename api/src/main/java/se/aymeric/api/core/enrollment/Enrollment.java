package se.aymeric.api.core.enrollment;

import java.time.LocalDateTime;

public class Enrollment {
    private int enrollmentId;
    private int userId; // Foreign Key to User
    private int courseId; // Foreign Key to Course
    private LocalDateTime enrollmentDate;
    private double completionStatus; // Completion percentage

    // Constructors, getters, and setters
}
