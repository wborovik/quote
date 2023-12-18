package com.example.quote.service;

import com.example.quote.model.Vote;
import com.example.quote.repository.VoteRepository;
import com.example.quote.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class VoteService extends AbstractService<Vote, VoteRepository> {
    private final static String MINUS = "minus";
    private final static String PLUS = "plus";

    public VoteService(VoteRepository repository) {
        super(repository);
    }

    public void plusOrMinusVote(Long id, String value) {
        var vote = getEntityById(id);
        if (PLUS.equals(value)) {
            vote.setVote(vote.getVote() + 1);
        }
        if (MINUS.equals(value)) {
            vote.setVote(vote.getVote() - 1);
        }
        updateEntityById(id, vote);
    }
}