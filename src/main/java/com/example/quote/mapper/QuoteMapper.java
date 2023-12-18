package com.example.quote.mapper;

import com.example.quote.dto.RequestQuoteDto;
import com.example.quote.model.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuoteMapper {
    @Mapping(target = "user.id", source = "userId")
    Quote requestQuoteDtoToQuote(RequestQuoteDto quoteDto);
}