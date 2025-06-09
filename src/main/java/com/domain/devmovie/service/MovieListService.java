package com.domain.devmovie.service;

import com.domain.devmovie.dto.*;

import java.util.List;

public interface MovieListService {

    ResponseMovieListDto createList(Long userId, RequestMovieListDto request);

    List<ResponseMovieListDto> getListsByUser(Long userId);

    void deleteList(Long listId);

    ResponseMovieListItemDto addMovieToList(Long listId, RequestMovieListItemDto request);

    void removeMovieFromList(Long itemId);
}
