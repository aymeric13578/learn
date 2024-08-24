package se.aymeric.api.composite.content;

import se.aymeric.api.composite.course.ServiceAddresses;

import java.util.List;

/*Aggregates data from Content-Service and Analytics-Service.*/
public class ContentAggregate {
    private final int moduleId;
    private final String moduleTitle;
    private final List<VideoSummary> videos;
    private final List<QuizSummary> quizzes;
    private final List<DocumentSummary> documents;
    private final ServiceAddresses serviceAddresses;

    public ContentAggregate(
            int moduleId,
            String moduleTitle,
            List<VideoSummary> videos,
            List<QuizSummary> quizzes,
            List<DocumentSummary> documents,
            ServiceAddresses serviceAddresses) {

        this.moduleId = moduleId;
        this.moduleTitle = moduleTitle;
        this.videos = videos;
        this.quizzes = quizzes;
        this.documents = documents;
        this.serviceAddresses = serviceAddresses;
    }

    public int getModuleId() { return moduleId; }
    public String getModuleTitle() { return moduleTitle; }
    public List<VideoSummary> getVideos() { return videos; }
    public List<QuizSummary> getQuizzes() { return quizzes; }
    public List<DocumentSummary> getDocuments() { return documents; }
    public ServiceAddresses getServiceAddresses() { return serviceAddresses; }
}
