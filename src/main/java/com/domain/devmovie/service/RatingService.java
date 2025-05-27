package com.domain.devmovie.service;

import com.domain.devmovie.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating addRating(Long userId, String movieId, Integer score, String comment);

    List<Rating> getRatingsByUser(Long userId);

    List<Rating> getRatingsByMovie(String movieId);
}
