package com.domain.devmovie.exceptions;

public class MovieListItemNotFoundException extends RuntimeException {
    public MovieListItemNotFoundException(String message) {
        super(message);
    }
}
