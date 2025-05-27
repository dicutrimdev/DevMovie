package com.domain.devmovie.exceptions;

public class UserMovieNotFoundException extends RuntimeException {
    public UserMovieNotFoundException(String message) {
        super(message);
    }
}
