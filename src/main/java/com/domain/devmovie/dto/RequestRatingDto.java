package com.domain.devmovie.dto;

import jakarta.validation.constraints.*;

public record RequestRatingDto(
        @NotBlank(message = "Movie ID must not be blank")
        String movieId,

        @NotNull(message = "Score is required")
        @Min(value = 0, message = "Score must be at least 0")
        @Max(value = 10, message = "Score must be at most 10")
        Integer score,

        @Size(max = 500, message = "Comment must be at most 500 characters")
        String comment
) {
}
