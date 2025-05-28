package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.domain.devmovie.dto.RequestUserMovieDto;
import com.domain.devmovie.service.UserMovieService;
import com.domain.devmovie.dto.ResponseUserMovieDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-movies")
public class UserMovieController {

    private final UserMovieService userMovieService;

    @PostMapping("/{userId}/favorites")
    public ResponseEntity<ResponseUserMovieDto> addFavorite(@PathVariable Long userId,
                                                            @RequestBody RequestUserMovieDto request) {
        ResponseUserMovieDto response = userMovieService.addFavorite(userId, request);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{userId}/favorites")
    public ResponseEntity<List<ResponseUserMovieDto>> getFavoritesByUser(@PathVariable Long userId) {
        List<ResponseUserMovieDto> favorites = userMovieService.getFavoritesByUser(userId);
        return ResponseEntity.ok(favorites);
    }


    @DeleteMapping("/favorites/{favoriteId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long favoriteId) {
        userMovieService.removeFavorite(favoriteId);
        return ResponseEntity.noContent().build();
    }

}
