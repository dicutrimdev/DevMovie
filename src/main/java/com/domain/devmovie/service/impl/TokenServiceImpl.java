package com.domain.devmovie.service.impl;

import com.auth0.jwt.JWT;
import com.domain.devmovie.entities.User;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.domain.devmovie.service.TokenService;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import com.domain.devmovie.exceptions.InvalidTokenException;
import com.domain.devmovie.exceptions.TokenGenerationException;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.LocalDateTime;

@Service
public class TokenServiceImpl implements TokenService {


    @Value("${devmovie.api.token.secret}")
    private String secret;


    @Override
    public String generateToken(UserDetails user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT
                    .create()
                    .withIssuer("DevMovie API")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new TokenGenerationException("Error while generating token", exception);
        }
    }


    @Override
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT
                    .require(algorithm)
                    .withIssuer("DevMovie API")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (Exception exception) {
            throw new InvalidTokenException("Invalid or expired token", exception);
        }
    }


    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
