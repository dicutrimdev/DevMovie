package com.domain.devmovie.dto;

import lombok.Data;

@Data
public class FilmeDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String imagem;
    private Double nota;
}
