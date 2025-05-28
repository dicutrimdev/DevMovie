package com.domain.devmovie.entities;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "TB_MOVIE_LIST")
public class MovieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "movieList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieListItem> items = new ArrayList<>();
}
