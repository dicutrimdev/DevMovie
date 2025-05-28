package com.domain.devmovie.mapper;

import com.domain.devmovie.entities.User;
import com.domain.devmovie.entities.UserMovie;
import com.domain.devmovie.dto.RequestUserMovieDto;
import com.domain.devmovie.dto.ResponseUserMovieDto;

public class UserMovieMapper {

    public static UserMovie fromRequestToEntity(RequestUserMovieDto dto, User user) {
        return UserMovie.builder()
                .movieId(dto.movieId())
                .title(dto.title())
                .posterUrl(dto.posterUrl())
                .user(user)
                .build();
    }


    public static ResponseUserMovieDto fromEntityToResponse(UserMovie userMovie) {
        return new ResponseUserMovieDto(
                userMovie.getId(),
                userMovie.getMovieId(),
                userMovie.getTitle(),
                userMovie.getPosterUrl()
        );

    }
}
