package com.domain.devmovie.mapper;

import com.domain.devmovie.dto.FilmeDTO;
import com.domain.devmovie.dto.TmdbDiscoverResponse;
import com.domain.devmovie.entities.MovieList;
import com.domain.devmovie.entities.MovieListItem;
import com.domain.devmovie.dto.ResponseMovieListDto;
import com.domain.devmovie.dto.ResponseMovieListItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieListMapper {


    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;


    public ResponseMovieListDto toDtoList(MovieList movieList) {
        List<ResponseMovieListItemDto> items = movieList
                .getItems()
                .stream()
                .map(item -> new ResponseMovieListItemDto(
                        item.getId(),buscarFilmePorId(item.getMovieId()))
                )
                .toList();
        return new ResponseMovieListDto(
                movieList.getId(),
                movieList.getName(),
                movieList.getDescription(),
                items);
    }


    public static ResponseMovieListItemDto toDto(MovieListItem item, FilmeDTO filmeDto) {
        return new ResponseMovieListItemDto(item.getId(), filmeDto);
    }


    public FilmeDTO buscarFilmePorId(String movieId) {
        var url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&language=pt-BR";
        var response = restTemplate.getForObject(url, TmdbDiscoverResponse.TmdbMovieResult.class);
        var dto = new FilmeDTO();
        dto.setId(Long.valueOf(movieId));
        dto.setTitulo(response.getTitle());
        dto.setDescricao(response.getOverview());
        dto.setImagem(response.getPoster_path());
        dto.setNota(response.getVote_average());
        return dto;
    }
}
