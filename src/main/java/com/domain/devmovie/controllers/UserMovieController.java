package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.service.UserMovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-movies")
public class UserMovieController {

    private final UserMovieService userMovieService;


}
