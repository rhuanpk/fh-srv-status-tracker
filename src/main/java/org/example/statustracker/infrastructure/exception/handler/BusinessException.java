package org.example.statustracker.infrastructure.exception.handler;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}
