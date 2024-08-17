package se.aymeric.microservices.core.course.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.aymeric.api.core.course.Course;
import se.aymeric.api.core.course.CourseService;
import se.aymeric.util.http.ServiceUtil;

import java.math.BigDecimal;

@RestController
public class CourseServiceImpl implements CourseService {

    private static final Logger LOG = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public CourseServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Course getCourse(int courseId) {
        LOG.debug("/course return the found course for courseId={}", courseId);

        if (courseId < 1) {
            throw new se.aymeric.api.exceptions.InvalidInputException("Invalid courseId: " + courseId);
        }

        if (courseId == 13) {
            throw new se.aymeric.api.exceptions.NotFoundException("No course found for courseId: " + courseId);
        }

       return new Course( courseId,  "title-"+courseId, "description"+courseId, 12,
         1, "difficultyLevel"+courseId, serviceUtil.getServiceAddress());
    }
}

