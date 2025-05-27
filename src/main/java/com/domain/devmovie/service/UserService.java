package com.domain.devmovie.service;

import com.domain.devmovie.dto.RequestUserDto;
import com.domain.devmovie.dto.ResponseUserDto;

public interface UserService {

    ResponseUserDto createUser(RequestUserDto dto);

    ResponseUserDto getUserByEmail(String email);

    ResponseUserDto getUserById(Long id);

    void deleteUser(Long id);
}
