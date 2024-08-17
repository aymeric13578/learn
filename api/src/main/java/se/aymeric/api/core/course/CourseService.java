package se.aymeric.api.core.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CourseService {

    /**
     * Sample usage: "curl $HOST:$PORT/course/1".
     *
     * @param courseId Id of the course
     * @return the course, if found, else null
     */
    @GetMapping(
            value = "/course/{courseId}",
            produces = "application/json")
    Course getCourse(@PathVariable int courseId);
}
