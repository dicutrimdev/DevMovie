package com.domain.devmovie.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devmovie.dto.RequestLoginDto;
import com.domain.devmovie.dto.ResponseLoginDto;
import com.domain.devmovie.service.LoginService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseLoginDto login(RequestLoginDto request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(), request.password())
        );
        var user = (UserDetails) auth.getPrincipal();
        return new ResponseLoginDto(user.getUsername());
    }
}
