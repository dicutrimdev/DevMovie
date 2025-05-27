package com.domain.devmovie.entities;

import lombok.*;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_MOVIE_LIST_ITEM")
public class MovieListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieId;
    private String title;
    private String posterUrl;

    @ManyToOne
    @JoinColumn(name = "movie_list_id")
    private MovieList movieList;
}
