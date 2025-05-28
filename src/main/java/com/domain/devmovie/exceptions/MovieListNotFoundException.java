package com.domain.devmovie.exceptions;

public class MovieListNotFoundException extends RuntimeException {
    public MovieListNotFoundException(String message) {
        super(message);
    }
}
