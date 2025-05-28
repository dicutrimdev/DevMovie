package com.domain.devmovie.service;

import com.domain.devmovie.dto.RequestMovieListDto;
import com.domain.devmovie.dto.ResponseMovieListDto;
import com.domain.devmovie.dto.RequestMovieListItemDto;
import com.domain.devmovie.dto.ResponseMovieListItemDto;

import java.util.List;

public interface MovieListService {

    ResponseMovieListDto createList(Long userId, RequestMovieListDto request);

    List<ResponseMovieListDto> getListsByUser(Long userId);

    void deleteList(Long listId);

    ResponseMovieListItemDto addMovieToList(Long listId, RequestMovieListItemDto request);

    void removeMovieFromList(Long itemId);
}
