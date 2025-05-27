package com.domain.devmovie.service;

import com.domain.devmovie.entities.MovieList;
import com.domain.devmovie.entities.MovieListItem;

import java.util.List;

public interface MovieListService {

    MovieList createList(Long userId, String name);

    List<MovieList> getListsByUser(Long userId);

    void deleteList(Long listId);

    MovieListItem addMovieToList(Long listId, String movieId, String title);

    void removeMovieFromList(Long itemId);
}
