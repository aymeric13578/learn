package se.aymeric.api.composite.content;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "ContentComposite", description = "REST API for composite content information.")
public interface ContentCompositeService {

    @Operation(
            summary = "Get composite content information",
            description = "Retrieve detailed content information for a module, including videos, quizzes, and documents.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Module not found"),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity")
    })
    @GetMapping(
            value = "/content-composite/{moduleId}",
            produces = "application/json")
    ContentAggregate getContent(@PathVariable int moduleId);
}
