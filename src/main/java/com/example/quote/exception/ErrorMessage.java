package com.example.quote.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
    private LocalDateTime timeStamp;
}
