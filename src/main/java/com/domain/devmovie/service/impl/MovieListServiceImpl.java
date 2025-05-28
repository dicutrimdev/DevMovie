package com.domain.devmovie.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devmovie.entities.MovieList;
import com.domain.devmovie.entities.MovieListItem;
import com.domain.devmovie.mapper.MovieListMapper;
import com.domain.devmovie.service.MovieListService;
import com.domain.devmovie.dto.ResponseMovieListDto;
import com.domain.devmovie.repositories.UserRepository;
import com.domain.devmovie.dto.ResponseMovieListItemDto;
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
    private final MovieListRepository movieListRepository;
    private final MovieListItemRepository movieListItemRepository;


    @Override
    @Transactional
    public ResponseMovieListDto createList(Long userId, String name) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found with id: " + userId)
        );
        var list = MovieList.builder().name(name).user(user).build();
        var savedList = movieListRepository.save(list);
        return MovieListMapper.toDtoList(savedList);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ResponseMovieListDto> getListsByUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new UserNotFoundException("User not found with id: " + userId);
        return movieListRepository.findByUserId(userId).stream()
                .map(MovieListMapper::toDtoList).toList();
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
    public ResponseMovieListItemDto addMovieToList(Long listId, String movieId, String title) {
        var list = movieListRepository.findById(listId).orElseThrow(
                () -> new MovieListNotFoundException("List not found with id: " + listId)
        );
        var item = MovieListItem.builder().movieId(movieId).title(title).movieList(list).build();
        var savedItem = movieListItemRepository.save(item);
        return MovieListMapper.toDto(savedItem);
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
