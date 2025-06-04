package com.domain.devmovie.entities.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum TmdbMovieGenre {

    ACAO(28, "Ação"),
    AVENTURA(12, "Aventura"),
    ANIMACAO(16, "Animação"),
    COMEDIA(35, "Comédia"),
    CRIME(80, "Crime"),
    DOCUMENTARIO(99, "Documentário"),
    DRAMA(18, "Drama"),
    FAMILIA(10751, "Família"),
    FANTASIA(14, "Fantasia"),
    HISTORIA(36, "História"),
    TERROR(27, "Terror"),
    MUSICA(10402, "Música"),
    MISTERIO(9648, "Mistério"),
    ROMANCE(10749, "Romance"),
    FICCAO_CIENTIFICA(878, "Ficção Científica"),
    FILME_PARA_TV(10770, "Filme para TV"),
    THRILLER(53, "Thriller"),
    GUERRA(10752, "Guerra"),
    FAROESTE(37, "Faroeste");

    private final int id;
    private final String description;

    public static Optional<TmdbMovieGenre> fromDescription(String description) {
        return Arrays.stream(values())
                .filter(g -> g.getDescription().equalsIgnoreCase(description))
                .findFirst();
    }
}
