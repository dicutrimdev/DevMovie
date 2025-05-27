package com.domain.devmovie.service;

import com.domain.devmovie.entities.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserByEmail(String email);

    User getUserById(Long id);

    void deleteUser(Long id);
}
