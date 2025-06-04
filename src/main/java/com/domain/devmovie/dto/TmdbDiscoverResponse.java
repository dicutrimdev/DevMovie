package com.domain.devmovie.dto;

import lombok.Data;

import java.util.List;

@Data
public class TmdbDiscoverResponse {
    private List<TmdbMovieResult> results;

    @Data
    public static class TmdbMovieResult {
        private String title;
        private String overview;
        private String poster_path;
        private Double vote_average;
    }
}
