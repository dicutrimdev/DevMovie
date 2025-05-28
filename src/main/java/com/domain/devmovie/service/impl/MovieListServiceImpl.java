package com.domain.devmovie.service.impl;

import com.domain.devmovie.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import com.domain.devmovie.entities.MovieList;
import org.springframework.stereotype.Service;
import com.domain.devmovie.entities.MovieListItem;
import com.domain.devmovie.service.MovieListService;
import com.domain.devmovie.repositories.UserRepository;
import com.domain.devmovie.repositories.MovieListRepository;
import com.domain.devmovie.repositories.MovieListItemRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieListServiceImpl implements MovieListService {


    private final UserRepository userRepository;
    private final MovieListRepository movieListRepository;
    private final MovieListItemRepository movieListItemRepository;



}
