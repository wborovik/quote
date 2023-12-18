package com.example.quote.exception;

public class EntityNotDeleteException extends RuntimeException {
    public EntityNotDeleteException(String message) {
        super(message);
    }
}