package com.example.quote.mapper;

import com.example.quote.dto.RequestUserDto;
import com.example.quote.model.UserAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserAccount requestUserDtoToUserAccount(RequestUserDto userDto);
}