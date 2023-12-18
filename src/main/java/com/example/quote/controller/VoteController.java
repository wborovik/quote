package com.example.quote.controller;

import com.example.quote.controller.common.AbstractController;
import com.example.quote.model.Vote;
import com.example.quote.repository.VoteRepository;
import com.example.quote.service.VoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("votes")
public class VoteController extends AbstractController<Vote, VoteService, VoteRepository> {
    public VoteController(VoteService service) {
        super(service);
    }
}