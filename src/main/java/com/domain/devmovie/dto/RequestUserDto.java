package com.domain.devmovie.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestUserDto(
        @NotBlank(message = "Name must not be blank")
        String name,

        @NotBlank(message = "Email must not be blank")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Password must not be blank")
        @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
        String password
) {
}
