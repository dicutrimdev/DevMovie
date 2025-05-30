package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import com.domain.devmovie.dto.RequestLoginDto;
import com.domain.devmovie.dto.ResponseLoginDto;
import com.domain.devmovie.service.LoginService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Login")
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    @Operation(
            summary = "User login",
            description = "Authenticates the user and returns a token if credentials are valid.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User authenticated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ResponseLoginDto> login(
            @Parameter(description = "Login request containing user email and password")
            @Valid @RequestBody RequestLoginDto request
    ) {
        ResponseLoginDto response = loginService.login(request);
        return ResponseEntity.ok(response);
    }
}
