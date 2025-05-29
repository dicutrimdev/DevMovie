package com.domain.devmovie.service;

import com.domain.devmovie.dto.ResponseUserDto;

public interface UserService {

    ResponseUserDto getUserByEmail(String email);

    ResponseUserDto getUserById(Long id);

    void deleteUser(Long id);
}
