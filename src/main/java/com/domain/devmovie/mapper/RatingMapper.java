package com.domain.devmovie.mapper;

import com.domain.devmovie.entities.Rating;
import com.domain.devmovie.dto.ResponseRatingDto;

public class RatingMapper {

    public static ResponseRatingDto toDto(Rating rating) {
        return new ResponseRatingDto(
                rating.getId(),
                rating.getMovieId(),
                rating.getScore(),
                rating.getComment(),
                rating.getUser().getId()
        );
    }
}