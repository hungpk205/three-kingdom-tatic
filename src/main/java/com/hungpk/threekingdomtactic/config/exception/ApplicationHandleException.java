package com.hungpk.threekingdomtactic.config.exception;

import com.hungpk.threekingdomtactic.utils.RestApiErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class ApplicationHandleException {

    private final MessageSource messageSource;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestApiErrorResponse notFoundException(NotFoundException ex, WebRequest request) {
        String errorMessage = messageSource.getMessage(ex.getMessage(), ex.getArgs(), request.getLocale());
        return new RestApiErrorResponse(HttpStatus.NOT_FOUND, errorMessage);
    }

    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestApiErrorResponse systemException(SystemException ex, WebRequest request) {
        String errorMessage = messageSource.getMessage(ex.getMessage(), null, request.getLocale());
        return new RestApiErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestApiErrorResponse exception(Exception ex, WebRequest request) {
        String errorMessage = messageSource.getMessage(ex.getMessage(), null, request.getLocale());
        return new RestApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }
}
