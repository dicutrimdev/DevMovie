package com.domain.devmovie.service;

import com.domain.devmovie.dto.ResponseMovieListDto;
import com.domain.devmovie.dto.ResponseMovieListItemDto;

import java.util.List;

public interface MovieListService {

    ResponseMovieListDto createList(Long userId, String name);

    List<ResponseMovieListDto> getListsByUser(Long userId);

    void deleteList(Long listId);

    ResponseMovieListItemDto addMovieToList(Long listId, String movieId, String title);

    void removeMovieFromList(Long itemId);
}
