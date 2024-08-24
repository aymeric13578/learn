package se.aymeric.util.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import se.aymeric.api.exception.InvalidInputException;
import se.aymeric.api.exception.NotFoundException;

import static org.springframework.http.HttpStatus.*;

/**
 * Global exception handler for managing specific exceptions and returning appropriate HTTP responses.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    /**
     * Handles NotFoundException and returns a NOT_FOUND (404) status.
     *
     * @param request the ServerHttpRequest
     * @param ex the NotFoundException
     * @return an HttpErrorInfo with error details
     */
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public HttpErrorInfo handleNotFoundException(ServerHttpRequest request, NotFoundException ex) {
        return createHttpErrorInfo(NOT_FOUND, request, ex);
    }

    /**
     * Handles InvalidInputException and returns an UNPROCESSABLE_ENTITY (422) status.
     *
     * @param request the ServerHttpRequest
     * @param ex the InvalidInputException
     * @return an HttpErrorInfo with error details
     */
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    @ResponseBody
    public HttpErrorInfo handleInvalidInputException(ServerHttpRequest request, InvalidInputException ex) {
        return createHttpErrorInfo(UNPROCESSABLE_ENTITY, request, ex);
    }

    /**
     * Handles BadRequestException and returns a BAD_REQUEST (400) status.
     *
     * @param request the ServerHttpRequest
     * @param ex the BadRequestException
     * @return an HttpErrorInfo with error details
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public HttpErrorInfo handleBadRequestException(ServerHttpRequest request, BadRequestException ex) {
        return createHttpErrorInfo(BAD_REQUEST, request, ex);
    }

    /**
     * Handles UnauthorizedException and returns an UNAUTHORIZED (401) status.
     *
     * @param request the ServerHttpRequest
     * @param ex the UnauthorizedException
     * @return an HttpErrorInfo with error details
     */
    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public HttpErrorInfo handleUnauthorizedException(ServerHttpRequest request, UnauthorizedException ex) {
        return createHttpErrorInfo(UNAUTHORIZED, request, ex);
    }

    /**
     * Handles ForbiddenException and returns a FORBIDDEN (403) status.
     *
     * @param request the ServerHttpRequest
     * @param ex the ForbiddenException
     * @return an HttpErrorInfo with error details
     */
    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    public HttpErrorInfo handleForbiddenException(ServerHttpRequest request, ForbiddenException ex) {
        return createHttpErrorInfo(FORBIDDEN, request, ex);
    }

    /**
     * Handles InternalServerErrorException and returns an INTERNAL_SERVER_ERROR (500) status.
     *
     * @param request the ServerHttpRequest
     * @param ex the InternalServerErrorException
     * @return an HttpErrorInfo with error details
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseBody
    public HttpErrorInfo handleInternalServerErrorException(ServerHttpRequest request, InternalServerErrorException ex) {
        return createHttpErrorInfo(INTERNAL_SERVER_ERROR, request, ex);
    }

    /**
     * Creates an HttpErrorInfo object with the status, request path, and exception message.
     *
     * @param httpStatus the HTTP status
     * @param request the ServerHttpRequest
     * @param ex the exception
     * @return an HttpErrorInfo with the error details
     */
    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, ServerHttpRequest request, Exception ex) {
        String path = request.getPath().pathWithinApplication().value();
        String message = ex.getMessage();

        // Log detailed error information
        LOG.error("Error occurred at path: {}, HTTP Status: {}, Message: {}", path, httpStatus, message);

        return new HttpErrorInfo(httpStatus, path, message);
    }
}