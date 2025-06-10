package com.domain.devmovie.service.impl;

import com.domain.devmovie.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devmovie.entities.MovieList;
import com.domain.devmovie.entities.MovieListItem;
import com.domain.devmovie.mapper.MovieListMapper;
import com.domain.devmovie.service.MovieListService;
import com.domain.devmovie.repositories.UserRepository;
import com.domain.devmovie.exceptions.UserNotFoundException;
import com.domain.devmovie.repositories.MovieListRepository;
import org.springframework.transaction.annotation.Transactional;
import com.domain.devmovie.repositories.MovieListItemRepository;
import com.domain.devmovie.exceptions.MovieListNotFoundException;
import com.domain.devmovie.exceptions.MovieListItemNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieListServiceImpl implements MovieListService {


    private final UserRepository userRepository;
    private final MovieListMapper movieListMapper;
    private final MovieListRepository movieListRepository;
    private final MovieListItemRepository movieListItemRepository;


    @Override
    @Transactional
    public ResponseMovieListDto createList(Long userId, RequestMovieListDto request) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found with id: " + userId)
        );
        var movieList = MovieList.builder().name(request.name())
                .description(request.description()).user(user).build();

        var savedList = movieListRepository.save(movieList);
        return movieListMapper.toDtoList(savedList);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ResponseMovieListDto> getListsByUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new UserNotFoundException("User not found with id: " + userId);
        return movieListRepository.findByUserId(userId).stream().map(movieListMapper::toDtoList).toList();
    }


    @Override
    @Transactional
    public void deleteList(Long listId) {
        var list = movieListRepository.findById(listId).orElseThrow(
                () -> new MovieListNotFoundException("List not found with id: " + listId)
        );
        movieListRepository.delete(list);
    }


    @Override
    @Transactional
    public ResponseMovieListItemDto addMovieToList(Long listId, RequestMovieListItemDto request) {
        var list = movieListRepository.findById(listId).orElseThrow(
                () -> new MovieListNotFoundException("List not found with id: " + listId)
        );
        var item = MovieListItem.builder().movieId(request.movieId()).movieList(list).build();
        var savedItem = movieListItemRepository.save(item);
        var filmeDto = movieListMapper.buscarFilmePorId(request.movieId());
        return MovieListMapper.toDto(savedItem, filmeDto);
    }


    @Override
    @Transactional
    public void removeMovieFromList(Long itemId) {
        MovieListItem item = movieListItemRepository.findById(itemId).orElseThrow(
                () -> new MovieListItemNotFoundException("Movie item not found with id: " + itemId)
        );
        movieListItemRepository.delete(item);
    }
}
