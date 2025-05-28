package com.domain.devmovie.dto;

import java.util.List;

public record ResponseMovieListDto(Long id, String name, List<ResponseMovieListItemDto> movies) {
}
