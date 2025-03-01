package com.assessmentrestapi.exception;

public class AcknowledgeNotFoundException extends RuntimeException {
    public AcknowledgeNotFoundException(String message) {
        super(message);
    }
}