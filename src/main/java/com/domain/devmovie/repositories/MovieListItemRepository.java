package com.domain.devmovie.repositories;

import com.domain.devmovie.entities.MovieListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieListItemRepository extends JpaRepository<MovieListItem, Long> {
    List<MovieListItem> findByMovieListId(Long movieListId);
}
