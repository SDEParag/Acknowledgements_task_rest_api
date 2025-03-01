package com.assessmentrestapi.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

  
    private static final Map<Class<? extends Exception>, String> ERROR_MESSAGES = new HashMap<>();

    static {
        ERROR_MESSAGES.put(AcknowledgeNotFoundException.class, "Acknowledgement not found in the system.");
        ERROR_MESSAGES.put(Exception.class, "An unexpected error occurred. Please try again.");
    }

    
    @ExceptionHandler(AcknowledgeNotFoundException.class)
    public ResponseEntity<String> handleAcknowledgeNotFound(AcknowledgeNotFoundException ex) {
        logger.error("Acknowledgement Not Found: {}", ex.getMessage());
        return new ResponseEntity<>(ERROR_MESSAGES.getOrDefault(AcknowledgeNotFoundException.class, ex.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unexpected Error: {}", ex.getMessage());
        return new ResponseEntity<>(ERROR_MESSAGES.getOrDefault(Exception.class, "Internal server error."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
