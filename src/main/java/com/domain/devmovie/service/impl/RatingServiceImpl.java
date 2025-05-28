package com.domain.devmovie.service.impl;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.entities.Rating;
import org.springframework.stereotype.Service;
import com.domain.devmovie.mapper.RatingMapper;
import com.domain.devmovie.service.RatingService;
import com.domain.devmovie.dto.ResponseRatingDto;
import com.domain.devmovie.repositories.UserRepository;
import com.domain.devmovie.repositories.RatingRepository;
import com.domain.devmovie.exceptions.UserNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;


    @Override
    @Transactional
    public ResponseRatingDto addRating(Long userId, String movieId, Integer score, String comment) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found with id: " + userId)
        );
        Rating rating = Rating.builder()
                .user(user)
                .movieId(movieId)
                .score(score)
                .comment(comment)
                .build();
        Rating savedRating = ratingRepository.save(rating);
        return RatingMapper.toDto(savedRating);
    }


    @Override
    @Transactional
    public List<ResponseRatingDto> getRatingsByUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new UserNotFoundException("User not found with id: " + userId);

        return ratingRepository.findByUserId(userId)
                .stream()
                .map(RatingMapper::toDto)
                .toList();
    }


    @Override
    @Transactional
    public List<ResponseRatingDto> getRatingsByMovie(String movieId) {
        return ratingRepository.findByMovieId(movieId)
                .stream()
                .map(RatingMapper::toDto)
                .toList();
    }
}
