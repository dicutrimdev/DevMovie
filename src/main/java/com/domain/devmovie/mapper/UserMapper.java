package com.domain.devmovie.mapper;

import com.domain.devmovie.dto.RequestUserDto;
import com.domain.devmovie.entities.User;

public class UserMapper {

    public static User from(RequestUserDto request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }
}
