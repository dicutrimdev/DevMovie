package com.domain.devmovie.repositories;

import com.domain.devmovie.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByUserId(Long userId);

    List<Rating> findByMovieId(String movieId);
}
