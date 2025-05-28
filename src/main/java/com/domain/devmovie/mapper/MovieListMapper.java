package com.domain.devmovie.mapper;

import com.domain.devmovie.entities.MovieList;
import com.domain.devmovie.entities.MovieListItem;
import com.domain.devmovie.dto.ResponseMovieListDto;
import com.domain.devmovie.dto.ResponseMovieListItemDto;

import java.util.List;

public class MovieListMapper {

    public static ResponseMovieListDto toDtoList(MovieList movieList) {
        List<ResponseMovieListItemDto> items = movieList.getItems().stream().map(MovieListMapper::toDto).toList();
        return new ResponseMovieListDto(movieList.getId(), movieList.getName(), items);
    }


    public static ResponseMovieListItemDto toDto(MovieListItem item) {
        return new ResponseMovieListItemDto(item.getId(), item.getMovieId(), item.getTitle());
    }
}
