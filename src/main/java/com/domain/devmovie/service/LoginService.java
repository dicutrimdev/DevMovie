package com.domain.devmovie.service;

import com.domain.devmovie.dto.RequestLoginDto;
import com.domain.devmovie.dto.ResponseLoginDto;

public interface LoginService {
    ResponseLoginDto login(RequestLoginDto request);
}
