package se.aymeric.api.composite.analytics;

import se.aymeric.api.composite.course.ServiceAddresses;

import java.util.List;
import java.util.Map;

/*Aggregates data from Enrollment-Service, Content-Service, Review-Service, and Payment-Service.*/
public class AnalyticsAggregate {
    private final int courseId;
    private List<EnrollmentProgress> courseProgress;
    private List<UserEngagement> userEngagement;
    private final double averageRating;
    private final double totalRevenue;
    private final ServiceAddresses serviceAddresses;

    public AnalyticsAggregate(
            int courseId,
            double averageRating,
            double totalRevenue,
            ServiceAddresses serviceAddresses) {

        this.courseId = courseId;
        this.averageRating = averageRating;
        this.totalRevenue = totalRevenue;
        this.serviceAddresses = serviceAddresses;
    }

    public int getCourseId() { return courseId; }
    public double getAverageRating() { return averageRating; }
    public double getTotalRevenue() { return totalRevenue; }
    public ServiceAddresses getServiceAddresses() { return serviceAddresses; }
}
