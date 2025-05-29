package com.domain.devmovie.service.impl;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.entities.User;
import com.domain.devmovie.mapper.UserMapper;
import com.domain.devmovie.dto.RequestUserDto;
import org.springframework.stereotype.Service;
import com.domain.devmovie.service.UserService;
import com.domain.devmovie.dto.ResponseUserDto;
import com.domain.devmovie.repositories.UserRepository;
import com.domain.devmovie.exceptions.UserNotFoundException;
import com.domain.devmovie.exceptions.EmailNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public ResponseUserDto getUserByEmail(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(
                () -> new EmailNotFoundException("User not found with email: " + email));
        return getResponseUserDto(user);
    }


    @Override
    @Transactional(readOnly = true)
    public ResponseUserDto getUserById(Long id) {
        var user = findUserByIdOrThrow(id);
        return getResponseUserDto(user);
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        var user = findUserByIdOrThrow(id);
        userRepository.delete(user);
    }


    private User findUserByIdOrThrow(Long id) {
        if (id == null)
            throw new IllegalArgumentException("User id must not be null");

        if (id <= 0)
            throw new IllegalArgumentException("User id must be greater than zero");

        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User id: " + id + " not found")
        );
    }


    private void validateUser(User user) {
        if (user.getName() == null || user.getName().isBlank())
            throw new IllegalArgumentException("The name field is required");

        if (user.getEmail() == null || user.getEmail().isBlank())
            throw new IllegalArgumentException("The email field is required");

        if (user.getPassword() == null || user.getPassword().isBlank())
            throw new IllegalArgumentException("The password field is required");
    }


    private static ResponseUserDto getResponseUserDto(User user) {
        return new ResponseUserDto(user.getId(), user.getName(), user.getEmail());
    }
}
