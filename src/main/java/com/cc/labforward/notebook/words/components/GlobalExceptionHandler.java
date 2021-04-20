package com.cc.labforward.notebook.words.components;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DEFAULT_ERROR_MESSAGE = "A problem was encountered while processing your request";


    @ExceptionHandler(value = { RuntimeException.class, Exception.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        AppFailureResponse bodyOfResponse = new AppFailureResponse(getExceptionMessage(ex), DEFAULT_ERROR_MESSAGE);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }


    @ExceptionHandler(value = { IllegalStateException.class })
    protected ResponseEntity<Object> handleIllegalStateConflict(IllegalStateException ex, WebRequest request) {
        AppFailureResponse bodyOfResponse = new AppFailureResponse(getExceptionMessage(ex), DEFAULT_ERROR_MESSAGE);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(String.format("%s: %s", error.getField(), error.getDefaultMessage()));
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(String.format("%s: %s", error.getObjectName(), error.getDefaultMessage()));
        }
        String message = String.join(", ", errors);
        AppFailureResponse bodyOfResponse = new AppFailureResponse(message, DEFAULT_ERROR_MESSAGE);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    private String getExceptionMessage(Exception ex) {
        if (ex instanceof NullPointerException || !StringUtils.hasText(ex.getMessage())) {
            return DEFAULT_ERROR_MESSAGE;
        }
        return ex.getMessage();
    }

}
