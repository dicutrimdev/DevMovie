package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.domain.devmovie.dto.RequestLoginDto;
import com.domain.devmovie.dto.ResponseLoginDto;
import com.domain.devmovie.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDto> login(@Valid @RequestBody RequestLoginDto request) {
        ResponseLoginDto response = loginService.login(request);
        return ResponseEntity.ok(response);
    }
}
