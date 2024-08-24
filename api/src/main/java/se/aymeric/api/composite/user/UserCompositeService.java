package se.aymeric.api.composite.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "UserComposite", description = "REST API for composite user information.")
public interface UserCompositeService {

    @Operation(
            summary = "Get composite user information",
            description = "Retrieve detailed user information, including enrollments, reviews, and recommendations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "422", description = "Unprocessable entity")
    })
    @GetMapping(
            value = "/user-composite/{userId}",
            produces = "application/json")
    UserAggregate getUser(@PathVariable int userId);
}
