package com.domain.devmovie.dto;

import java.util.List;

public record ResponseMovieListDto(
        Long id,
        String name,
        String description,
        List<ResponseMovieListItemDto> movies) {
}
