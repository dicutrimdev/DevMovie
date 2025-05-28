package com.domain.devmovie.service;

import com.domain.devmovie.dto.RequestUserMovieDto;
import com.domain.devmovie.dto.ResponseUserMovieDto;

import java.util.List;

public interface UserMovieService {

    ResponseUserMovieDto addFavorite(Long userId, RequestUserMovieDto request);

    List<ResponseUserMovieDto> getFavoritesByUser(Long userId);

    void removeFavorite(Long favoriteId);
}
