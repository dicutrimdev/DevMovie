package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.dto.ResponseRatingDto;
import com.domain.devmovie.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;


    @PostMapping
    public ResponseRatingDto addRating(
            @RequestParam Long userId,
            @RequestParam String movieId,
            @RequestParam Integer score,
            @RequestParam(required = false) String comment
    ) {
        return ratingService.addRating(userId, movieId, score, comment);
    }


    @GetMapping("/user/{userId}")
    public List<ResponseRatingDto> getRatingsByUser(@PathVariable Long userId) {
        return ratingService.getRatingsByUser(userId);
    }


    @GetMapping("/movie/{movieId}")
    public List<ResponseRatingDto> getRatingsByMovie(@PathVariable String movieId) {
        return ratingService.getRatingsByMovie(movieId);
    }
}
