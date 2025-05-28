package com.domain.devmovie.dto;

import lombok.Builder;

@Builder
public record ResponseUserMovieDto(Long id, String movieId, String title, String posterUrl) {
}
