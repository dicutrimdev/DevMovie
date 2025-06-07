package com.domain.devmovie.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.domain.devmovie.dto.RequestUserMovieDto;
import com.domain.devmovie.service.UserMovieService;
import com.domain.devmovie.dto.ResponseUserMovieDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@Tag(name = "UserMovie")
@RequiredArgsConstructor

@RestController
@RequestMapping("/api/user-movies")
public class UserMovieController {


    private final UserMovieService userMovieService;


    @PostMapping("/{userId}/favorites")
    @Operation(
            summary = "Add a movie to user's favorites",
            description = "Add a specific movie to the user's list of favorites by providing the user ID and movie details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully added to favorites"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ResponseUserMovieDto> addFavorite(@PathVariable Long userId,
                                                            @Valid @RequestBody RequestUserMovieDto request) {
        ResponseUserMovieDto response = userMovieService.addFavoriteToWatchLater(userId, request);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{userId}/favorites")
    @Operation(
            summary = "Retrieve user's favorite movies",
            description = "Fetch the list of favorite movies for a specific user by providing the user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Favorite movies retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<ResponseUserMovieDto>> getFavoritesByUser(
            @Parameter(description = "The ID of the user") @PathVariable Long userId) {
        List<ResponseUserMovieDto> favorites = userMovieService.getFavoritesByUser(userId);
        return ResponseEntity.ok(favorites);
    }


    @DeleteMapping("/favorites/{favoriteId}")
    @Operation(
            summary = "Remove a movie from user's favorites",
            description = "Delete a specific favorite movie entry by providing its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie removed from favorites successfully"),
            @ApiResponse(responseCode = "404", description = "Favorite movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> removeFavorite(
            @Parameter(description = "The ID of the favorite movie to remove") @PathVariable Long favoriteId) {
        userMovieService.removeFavorite(favoriteId);
        return ResponseEntity.noContent().build();
    }
}
