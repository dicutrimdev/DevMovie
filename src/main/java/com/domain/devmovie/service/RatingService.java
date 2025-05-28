package com.domain.devmovie.service;

import com.domain.devmovie.dto.RequestRatingDto;
import com.domain.devmovie.dto.ResponseRatingDto;

import java.util.List;

public interface RatingService {

    ResponseRatingDto addRating(Long userId, RequestRatingDto request);

    List<ResponseRatingDto> getRatingsByUser(Long userId);

    List<ResponseRatingDto> getRatingsByMovie(String movieId);
}
