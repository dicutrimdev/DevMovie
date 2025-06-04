package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.dto.FilmeDTO;
import com.domain.devmovie.mapper.GeneroMapper;
import com.domain.devmovie.service.FilmeService;
import com.domain.devmovie.entities.enums.TmdbMovieGenre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/filmes")
public class FilmeController {
    private final FilmeService filmeService;

    @GetMapping
    public List<FilmeDTO> buscarPorGenero(@RequestParam String genero) {
        TmdbMovieGenre generoEnum = GeneroMapper.fromDescription(genero);
        return filmeService.buscarFilmesPorGenero(generoEnum);
    }
}
