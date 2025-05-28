package com.domain.devmovie.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MethodArgumentNotValidMessages {
    private String attribute;
    private String message;
}
