package se.aymeric.api.core.recommendation;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface RecommendationService {

    /**
     * Sample usage: "curl $HOST:$PORT/recommendation?courseId=1".
     *
     * @param courseId Id of the product
     * @return the recommendations of the course
     */
    @GetMapping(
            value = "/recommendation",
            produces = "application/json")
    List<Recommendation> getRecommendations(
            @RequestParam(value = "courseId", required = true) int courseId);
}
