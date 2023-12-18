package com.example.quote.service;

import com.example.quote.dto.RequestQuoteDto;
import com.example.quote.mapper.QuoteMapper;
import com.example.quote.model.Quote;
import com.example.quote.model.Vote;
import com.example.quote.repository.QuoteRepository;
import com.example.quote.service.common.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService extends AbstractService<Quote, QuoteRepository> {

    private final static String FLOP = "flop";
    private final QuoteMapper quoteMapper;
    private final VoteService voteService;

    public QuoteService(QuoteRepository repository, QuoteMapper quoteMapper, VoteService voteService) {
        super(repository);
        this.quoteMapper = quoteMapper;
        this.voteService = voteService;
    }

    public Quote createQuote(RequestQuoteDto quoteDto) {
        var quote = quoteMapper.requestQuoteDtoToQuote(quoteDto);
        quote.setVote(voteService.createEntity(new Vote()));

        return createEntity(quote);
    }

    public Quote updateQuoteById(Long id, RequestQuoteDto quoteDto) {
        return updateEntityById(id, quoteMapper.requestQuoteDtoToQuote(quoteDto));
    }

    public Quote updateVoteByQuote(Long id, String value) {
        var quote = getEntityById(id);
        voteService.plusOrMinusVote(quote.getVote().getId(), value);

        return quote;
    }

    public List<Quote> getTopOrFlopTenQuotes(String value) {
        if (FLOP.equals(value)) {
            return repository.getFlopTenQuotes();
        }
        return repository.getTopTenQuotes();
    }
    public Quote getRandomQuote() {
        return repository.getRandomQuote().orElseThrow();
    }
}