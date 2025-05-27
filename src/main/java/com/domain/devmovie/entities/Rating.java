package com.domain.devmovie.entities;

import lombok.*;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_RATING")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieId;
    private String title;
    private String posterUrl;
    private Integer score;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
