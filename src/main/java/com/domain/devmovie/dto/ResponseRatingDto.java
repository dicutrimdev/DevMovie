package com.domain.devmovie.dto;

public record ResponseRatingDto(Long id, String movieId, Integer score, String comment, Long userId) {
}
