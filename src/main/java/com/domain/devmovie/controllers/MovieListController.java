package com.domain.devmovie.controllers;

import com.domain.devmovie.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.domain.devmovie.service.MovieListService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devmovie")
public class MovieListController {

    private final MovieListService movieListService;


    @PostMapping("/users/{userId}/movie-list")
    @Operation(summary = "Create a movie list", description = "Creates a new movie list for a specific user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie list created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<ResponseMovieListDto> createList(
            @Parameter(description = "User ID who owns the list") @PathVariable Long userId,
            @Valid @RequestBody RequestMovieListDto request) {
        ResponseMovieListDto createdList = movieListService.createList(userId, request);
        return ResponseEntity.ok(createdList);
    }


    @GetMapping("/my-lists/user/{userId}")
    @Operation(summary = "Get all movie lists of a user",
            description = "Retrieves all movie lists created by a specific user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie lists retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<ResponseMovieListDto>> getListsByUser(
            @Parameter(description = "User ID") @PathVariable Long userId) {
        List<ResponseMovieListDto> lists = movieListService.getListsByUser(userId);
        return ResponseEntity.ok(lists);
    }


    @DeleteMapping("/movie-lists/{listId}")
    @Operation(summary = "Delete a movie list", description = "Deletes a movie list by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie list deleted successfully"),
            @ApiResponse(responseCode = "404", description = "List not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")})
    public ResponseEntity<Void> deleteList(@Parameter(description = "Movie list ID") @PathVariable Long listId) {
        movieListService.deleteList(listId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("lists/{listId}/add-movie")
    @Operation(summary = "Add a movie to a list", description = "Adds a movie to an existing movie list.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie added to list successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "List not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ResponseMovieListItemDto> addMovieToList(
            @Parameter(description = "Movie list ID") @PathVariable Long listId,
            @Valid @RequestBody RequestMovieListItemDto request) {
        ResponseMovieListItemDto addedMovie = movieListService.addMovieToList(listId, request);
        return ResponseEntity.ok(addedMovie);
    }


    @DeleteMapping("/item/{itemId}")
    @Operation(summary = "Remove a movie from a list",
            description = "Removes a movie from a list by its item ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie removed from list successfully"),
            @ApiResponse(responseCode = "404", description = "List item not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> removeMovieFromList(
            @Parameter(description = "Movie list item ID") @PathVariable Long itemId) {
        movieListService.removeMovieFromList(itemId);
        return ResponseEntity.noContent().build();
    }
}
