package com.domain.devmovie.service;

import com.domain.devmovie.entities.UserMovie;

import java.util.List;

public interface UserMovieService {

    UserMovie addFavorite(Long userId, String movieId, String title);

    List<UserMovie> getFavoritesByUser(Long userId);

    void removeFavorite(Long favoriteId);
}
