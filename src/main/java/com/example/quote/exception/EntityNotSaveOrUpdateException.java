package com.example.quote.exception;

public class EntityNotSaveOrUpdateException extends RuntimeException {
    public EntityNotSaveOrUpdateException(String message) {
        super(message);
    }
}