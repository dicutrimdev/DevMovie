package com.domain.devmovie.service;

import com.domain.devmovie.entities.User;
import com.domain.devmovie.dto.RequestUserDto;
import com.domain.devmovie.dto.ResponseUserDto;

public interface UserService {

    ResponseUserDto createUser(RequestUserDto dto);

    User getUserByEmail(String email);

    User getUserById(Long id);

    void deleteUser(Long id);
}
