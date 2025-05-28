package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.domain.devmovie.dto.RequestRatingDto;
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
    public ResponseRatingDto addRating(@RequestParam Long userId, @Valid @RequestBody RequestRatingDto request) {
        return ratingService.addRating(userId, request);
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
