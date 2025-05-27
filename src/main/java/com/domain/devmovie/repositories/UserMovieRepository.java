package com.domain.devmovie.repositories;

import com.domain.devmovie.entities.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {
    List<UserMovie> findByUserId(Long userId);
}
