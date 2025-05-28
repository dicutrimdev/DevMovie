package com.domain.devmovie.service;

import com.domain.devmovie.dto.ResponseRatingDto;

import java.util.List;

public interface RatingService {

    ResponseRatingDto addRating(Long userId, String movieId, Integer score, String comment);

    List<ResponseRatingDto> getRatingsByUser(Long userId);

    List<ResponseRatingDto> getRatingsByMovie(String movieId);
}
