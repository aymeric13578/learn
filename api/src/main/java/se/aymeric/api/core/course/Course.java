package se.aymeric.api.core.course;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Course {
    /*private int courseId;
    private String title;
    private String description;
    private double price;
    private User instructor; // Many-to-One relationship with User
    private List<Module> modules;
    private List<Enrollment> enrollments;
    private List<Review> reviews;
    private List<Recommendation> recommendations;
    private List<Payment> payments;*/
    private final int courseId;
    private final String serviceAddress;

    private String title;
    private String description;
    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private int popularityScore;
    private String difficultyLevel;

    public Course() {
        courseId = 0;
        title = null;
        description = null;
        price = 0;
        createdAt = null;
        updatedAt = null;
        popularityScore = 0;
        difficultyLevel = null;
        serviceAddress = null;
    }

    public Course(int courseId, String title,String description,double price,
                  int popularityScore,String difficultyLevel,String serviceAddress) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.popularityScore = popularityScore;
        this.difficultyLevel = difficultyLevel;
        this.serviceAddress = serviceAddress;
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

    public String getServiceAddress() {
        return serviceAddress;
    }
/*
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "course")
    private Set<Module> modules;

    @OneToMany(mappedBy = "course")
    private Set<CourseContent> courseContents;

    @OneToMany(mappedBy = "course")
    private Set<CourseMaterial> courseMaterials;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private Set<Waitlist> waitlist;

    @OneToMany(mappedBy = "course")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "course")
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "course")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "course")
    private Set<Recommendation> recommendations;

    @OneToMany(mappedBy = "course")
    private Set<Analytics> analytics;
*/

}
