package se.aymeric.api.composite.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "CourseComposite", description = "REST API for composite course information.")
public interface CourseCompositeService {

    /**
     * Sample usage: "curl $HOST:$PORT/course-composite/1".
     *
     * @param courseId Id of the course
     * @return the composite course info, if found, else null
     */
    @Operation(
            summary = "${api.course-composite.get-composite-course.description}",
            description = "${api.course-composite.get-composite-course.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "400", description = "${api.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "404", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "422", description = "${api.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(
            value = "/course-composite/{courseId}",
            produces = "application/json")
    CourseAggregate getCourse(@PathVariable int courseId);
}
