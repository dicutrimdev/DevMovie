package com.domain.devmovie.service.impl;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.entities.User;
import org.springframework.stereotype.Service;
import com.domain.devmovie.dto.RequestRegisterUser;
import com.domain.devmovie.service.RegisterService;
import com.domain.devmovie.dto.ResponseRegisterUser;
import com.domain.devmovie.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import com.domain.devmovie.exceptions.EmailAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public ResponseRegisterUser register(RequestRegisterUser request) {
        if (userRepository.existsByEmail(request.email()))
            throw new EmailAlreadyExistsException("Email already in use: " + request.email());

        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        var savedUser = userRepository.save(user);
        return new ResponseRegisterUser(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
}
