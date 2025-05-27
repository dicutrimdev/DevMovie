package com.domain.devmovie.mapper;

import com.domain.devmovie.entities.User;
import com.domain.devmovie.entities.UserMovie;

public class UserMovieMapper {

    public static UserMovie from(User user, String movieId, String title) {
        return UserMovie.builder()
                .movieId(movieId)
                .title(title)
                .user(user)
                .build();
    }
}
