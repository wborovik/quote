package com.example.quote.controller;

import com.example.quote.controller.common.AbstractController;
import com.example.quote.dto.RequestUserDto;
import com.example.quote.model.UserAccount;
import com.example.quote.repository.UserAccountRepository;
import com.example.quote.service.UserAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserAccountController extends AbstractController<UserAccount, UserAccountService, UserAccountRepository> {
    public UserAccountController(UserAccountService service) {
        super(service);
    }

    @PostMapping
    public UserAccount createUser(@RequestBody RequestUserDto userDto) {
        return service.createUser(userDto);
    }
}