package com.example.quote.controller;

import com.example.quote.controller.common.AbstractController;
import com.example.quote.dto.RequestQuoteDto;
import com.example.quote.model.Quote;
import com.example.quote.repository.QuoteRepository;
import com.example.quote.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quotes")
public class QuoteController extends AbstractController<Quote, QuoteService, QuoteRepository> {
    public QuoteController(QuoteService service) {
        super(service);
    }

    @PostMapping
    public Quote createQuote(@RequestBody RequestQuoteDto quoteDto) {
        return service.createQuote(quoteDto);
    }

    @PatchMapping("{id}")
    public Quote updateQuoteById(@PathVariable Long id, @RequestBody RequestQuoteDto quoteDto) {
        return service.updateQuoteById(id, quoteDto);
    }

    @PatchMapping("{id}/{value}")
    public Quote updateVoteByQuote(@PathVariable Long id, @PathVariable String value) {
        return service.updateVoteByQuote(id, value);
    }

    @GetMapping("rating/{value}")
    public List<Quote> getTopOrFlopTenQuotes(@PathVariable String value) {
        return service.getTopOrFlopTenQuotes(value);
    }

    @GetMapping("random")
    public Quote getRandomQuote() {
        return service.getRandomQuote();
    }
}