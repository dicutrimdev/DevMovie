package com.domain.devmovie.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestMovieListItemDto(
        @NotBlank(message = "Movie ID must not be blank")
        String movieId) {
}
