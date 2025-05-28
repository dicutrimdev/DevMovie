package com.domain.devmovie.dto;

public record RequestRatingDto(String movieId, Integer score, String comment) {
}
