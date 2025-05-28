package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.domain.devmovie.dto.ResponseMovieListDto;
import com.domain.devmovie.service.MovieListService;
import com.domain.devmovie.dto.ResponseMovieListItemDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie-lists")
public class MovieListController {

    private final MovieListService movieListService;


    @PostMapping("/create")
    public ResponseEntity<ResponseMovieListDto> createList(
            @RequestParam Long userId,
            @RequestParam String name) {
        ResponseMovieListDto createdList = movieListService.createList(userId, name);
        return ResponseEntity.ok(createdList);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResponseMovieListDto>> getListsByUser(@PathVariable Long userId) {
        List<ResponseMovieListDto> lists = movieListService.getListsByUser(userId);
        return ResponseEntity.ok(lists);
    }


    @DeleteMapping("/{listId}")
    public ResponseEntity<Void> deleteList(@PathVariable Long listId) {
        movieListService.deleteList(listId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{listId}/add-movie")
    public ResponseEntity<ResponseMovieListItemDto> addMovieToList(
            @PathVariable Long listId,
            @RequestParam String movieId,
            @RequestParam String title) {
        ResponseMovieListItemDto addedMovie = movieListService.addMovieToList(listId, movieId, title);
        return ResponseEntity.ok(addedMovie);
    }


    @DeleteMapping("/item/{itemId}")
    public ResponseEntity<Void> removeMovieFromList(@PathVariable Long itemId) {
        movieListService.removeMovieFromList(itemId);
        return ResponseEntity.noContent().build();
    }
}
