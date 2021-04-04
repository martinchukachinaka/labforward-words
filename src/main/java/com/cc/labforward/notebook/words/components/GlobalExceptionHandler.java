package com.cc.labforward.notebook.words.components;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DEFAULT_ERROR_MESSAGE = "A problem was encountered while processing your request";


    @ExceptionHandler(value = { RuntimeException.class, Exception.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        AppFailureResponse bodyOfResponse = new AppFailureResponse(getExceptionMessage(ex), DEFAULT_ERROR_MESSAGE);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }


    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<Object> handleArgumentsConflict(IllegalArgumentException ex, WebRequest request) {
        String message = getExceptionMessage(ex);
        AppFailureResponse bodyOfResponse = new AppFailureResponse(message, DEFAULT_ERROR_MESSAGE);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.PRECONDITION_FAILED, request);
    }


    @ExceptionHandler(value = { IllegalStateException.class })
    protected ResponseEntity<Object> handleIllegalStateConflict(IllegalStateException ex, WebRequest request) {
        AppFailureResponse bodyOfResponse = new AppFailureResponse(getExceptionMessage(ex), DEFAULT_ERROR_MESSAGE);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }


    private String getExceptionMessage(Exception ex) {
        if (ex instanceof NullPointerException || !StringUtils.hasText(ex.getMessage())) {
            return DEFAULT_ERROR_MESSAGE;
        }
        return ex.getMessage();
    }

}
