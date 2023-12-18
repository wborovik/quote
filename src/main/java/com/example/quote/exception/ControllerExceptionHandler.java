package com.example.quote.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorMessage entityNotFoundException(Exception ex) {
        log.error(String.format("Error: %s", ex.getMessage()), ex);
        return getMessageError(ex, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotSaveOrUpdateException.class, EntityNotDeleteException.class})
    public ErrorMessage entityNotSaveException(Exception ex) {
        log.error(String.format("Error: %s", ex.getMessage()), ex);
        return getMessageError(ex, HttpStatus.BAD_REQUEST);
    }

    private ErrorMessage getMessageError(Exception ex, HttpStatus status) {
        ErrorMessage message = new ErrorMessage();
        message.setTimeStamp(LocalDateTime.now());
        message.setStatus(status.value());
        message.setMessage(ex.getMessage());

        return message;
    }
}