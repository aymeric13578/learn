package se.aymeric.api.composite.analytics;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "AnalyticsComposite", description = "REST API for composite analytics information.")
public interface AnalyticsCompositeService {

    @Operation(
            summary = "Get composite analytics information",
            description = "Retrieve detailed analytics information for a course, including enrollments, ratings, revenue, and engagement metrics.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Course not found"),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity")
    })
    @GetMapping(
            value = "/analytics-composite/{courseId}",
            produces = "application/json")
    AnalyticsAggregate getAnalytics(@PathVariable int courseId);
}
