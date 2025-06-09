package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import com.domain.devmovie.service.RegisterService;
import com.domain.devmovie.dto.RequestRegisterUser;
import com.domain.devmovie.dto.ResponseRegisterUser;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Register")
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/register")
    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account by providing name, email, and password. " +
                    "The password will be stored securely (encrypted).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ResponseRegisterUser> register(@Valid @RequestBody RequestRegisterUser request) {
        ResponseRegisterUser response = registerService.register(request);
        return ResponseEntity.ok(response);
    }
}
