package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.domain.devmovie.service.RegisterService;
import com.domain.devmovie.dto.RequestRegisterUser;
import com.domain.devmovie.dto.ResponseRegisterUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterUser> register(@Valid @RequestBody RequestRegisterUser request) {
        ResponseRegisterUser response = registerService.register(request);
        return ResponseEntity.ok(response);
    }
}
