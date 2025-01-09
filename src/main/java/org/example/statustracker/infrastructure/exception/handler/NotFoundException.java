package org.example.statustracker.infrastructure.exception.handler;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
