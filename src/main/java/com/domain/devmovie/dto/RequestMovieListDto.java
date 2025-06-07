package com.domain.devmovie.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestMovieListDto(
        @NotBlank(message = "List name must not be blank")
        String name,
        String description
) {
}
