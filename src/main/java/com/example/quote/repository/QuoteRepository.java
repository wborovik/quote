package com.example.quote.repository;

import com.example.quote.model.Quote;
import com.example.quote.repository.common.AbstractRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends AbstractRepository<Quote> {
    @Query("select q from Quote q " +
            "join Vote v " +
            "on v.id = q.vote.id " +
            "order by v.vote asc " +
            "limit 10 ")
    List<Quote> getFlopTenQuotes();

    @Query("select q from Quote q " +
            "join Vote v " +
            "on v.id = q.vote.id " +
            "order by v.vote desc " +
            "limit 10 ")
    List<Quote> getTopTenQuotes();

    @Query("select q from Quote q " +
            "order by rand() " +
            "limit 1 ")
    Optional<Quote> getRandomQuote();
}