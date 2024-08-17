package se.aymeric.api.core.review;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewService {

    /**
     * Sample usage: "curl $HOST:$PORT/review?courseId=1".
     *
     * @param courseId Id of the course
     * @return the reviews of the course
     */
    @GetMapping(
            value = "/review",
            produces = "application/json")
    List<Review> getReviews(@RequestParam(value = "courseId", required = true) int courseId);
}
