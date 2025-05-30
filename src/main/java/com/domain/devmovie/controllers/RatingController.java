package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import com.domain.devmovie.dto.RequestRatingDto;
import com.domain.devmovie.dto.ResponseRatingDto;
import com.domain.devmovie.service.RatingService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@Tag(name = "Rating")
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/ratings")
public class RatingController {


    private final RatingService ratingService;


    @Operation(
            summary = "Add a new rating",
            description = "Allows a user to rate a movie by providing user ID and movie details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rating added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseRatingDto addRating(
            @Parameter(description = "ID of the user adding the rating", example = "1")
            @RequestParam Long userId,
            @Valid @RequestBody RequestRatingDto request) {
        return ratingService.addRating(userId, request);
    }


    @Operation(
            summary = "Get ratings by user ID",
            description = "Fetch all ratings made by a specific user."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ratings retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/user/{userId}")
    public List<ResponseRatingDto> getRatingsByUser(@PathVariable Long userId) {
        return ratingService.getRatingsByUser(userId);
    }


    @GetMapping("/movie/{movieId}")
    @Operation(
            summary = "Get ratings by movie ID",
            description = "Fetch all ratings for a specific movie."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ratings retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<ResponseRatingDto> getRatingsByMovie(@PathVariable String movieId) {
        return ratingService.getRatingsByMovie(movieId);
    }
}
