package com.domain.devmovie.service;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.dto.FilmeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.domain.devmovie.dto.TmdbDiscoverResponse;
import com.domain.devmovie.entities.enums.TmdbMovieGenre;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {
    private final RestTemplate restTemplate;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public List<FilmeDTO> buscarFilmesPorGenero(TmdbMovieGenre genero) {
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey +
                "&language=pt-BR&with_genres=" + genero.getId();

        var response = restTemplate.getForObject(url, TmdbDiscoverResponse.class);

        return response.getResults().stream().map(result -> {
            FilmeDTO dto = new FilmeDTO();
            dto.setTitulo(result.getTitle());
            dto.setDescricao(result.getOverview());
            dto.setImagem(result.getPoster_path());
            dto.setNota(result.getVote_average());
            return dto;
        }).toList();
    }
}
