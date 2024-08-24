package se.aymeric.api.core.course;

import se.aymeric.api.core.content.Document;
import se.aymeric.api.core.content.Quiz;

import java.util.List;

public class Module {
    private int moduleId;
    private int courseId; // Foreign Key to Course
    private String title;
    private List<Video> videos;
    private List<Quiz> quizzes;
    private List<Document> documents;

    // Constructors, getters, and setters
}
