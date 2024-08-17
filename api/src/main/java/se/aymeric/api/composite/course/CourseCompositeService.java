package se.aymeric.api.composite.course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CourseCompositeService {

    /**
     * Sample usage: "curl $HOST:$PORT/course-composite/1".
     *
     * @param courseId Id of the course
     * @return the composite course info, if found, else null
     */
    @GetMapping(
            value = "/course-composite/{courseId}",
            produces = "application/json")
    CourseAggregate getCourse(@PathVariable int courseId);
}
