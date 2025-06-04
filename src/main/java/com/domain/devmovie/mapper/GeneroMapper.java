package com.domain.devmovie.mapper;

import com.domain.devmovie.entities.enums.TmdbMovieGenre;

public class GeneroMapper {

    public static TmdbMovieGenre fromDescription(String description) {
        for (TmdbMovieGenre genero : TmdbMovieGenre.values())
            if (genero.getDescription().equalsIgnoreCase(description)) return genero;
        throw new IllegalArgumentException("Gênero inválido: " + description);
    }
}
