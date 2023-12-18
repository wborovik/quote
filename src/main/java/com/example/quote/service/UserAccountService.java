package com.example.quote.service;

import com.example.quote.dto.RequestUserDto;
import com.example.quote.mapper.UserMapper;
import com.example.quote.model.UserAccount;
import com.example.quote.repository.UserAccountRepository;
import com.example.quote.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService extends AbstractService<UserAccount, UserAccountRepository> {
    private final UserMapper userMapper;

    public UserAccountService(UserAccountRepository repository, UserMapper userMapper) {
        super(repository);
        this.userMapper = userMapper;
    }

    public UserAccount createUser(RequestUserDto userDto) {
        return createEntity(userMapper.requestUserDtoToUserAccount(userDto));
    }
}