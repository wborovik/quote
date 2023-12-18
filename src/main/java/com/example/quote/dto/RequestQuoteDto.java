package com.example.quote.dto;

import lombok.Data;

@Data
public class RequestQuoteDto {
    private String quote;
    private Long userId;
}