package com.domain.devmovie.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devmovie.mapper.UserMovieMapper;
import com.domain.devmovie.dto.RequestUserMovieDto;
import com.domain.devmovie.dto.ResponseUserMovieDto;
import com.domain.devmovie.service.UserMovieService;
import com.domain.devmovie.repositories.UserRepository;
import com.domain.devmovie.exceptions.UserNotFoundException;
import com.domain.devmovie.repositories.UserMovieRepository;
import org.springframework.transaction.annotation.Transactional;
import com.domain.devmovie.exceptions.UserMovieNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMovieServiceImpl implements UserMovieService {


    private final UserRepository userRepository;
    private final UserMovieRepository userMovieRepository;


    @Override
    @Transactional
    public ResponseUserMovieDto addFavoriteToWatchLater(Long userId, RequestUserMovieDto request) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found with id: " + userId));

        var userMovie = UserMovieMapper.fromRequestToEntity(request, user);
        var savedUserMovie = userMovieRepository.save(userMovie);

        return UserMovieMapper.fromEntityToResponse(savedUserMovie);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ResponseUserMovieDto> getFavoritesByUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new UserNotFoundException("User not found with id: " + userId);

        return userMovieRepository.findByUserId(userId).stream()
                .map(UserMovieMapper::fromEntityToResponse)
                .toList();
    }


    @Override
    public void removeFavorite(Long favoriteId) {
        var favorite = userMovieRepository.findById(favoriteId).orElseThrow(
                () -> new UserMovieNotFoundException("Favorite not found with id: " + favoriteId));
        userMovieRepository.delete(favorite);
    }
}
