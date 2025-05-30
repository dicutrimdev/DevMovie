package com.domain.devmovie.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {

    String generateToken(UserDetails user);

    String validateToken(String token);
}
