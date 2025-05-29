package com.domain.devmovie.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestRegisterUser(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve ser válido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
        String password
) {
}
