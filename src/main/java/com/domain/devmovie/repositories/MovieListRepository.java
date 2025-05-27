package com.domain.devmovie.repositories;

import com.domain.devmovie.entities.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieListRepository extends JpaRepository<MovieList, Long> {
    List<MovieList> findByUserId(Long userId);
}
