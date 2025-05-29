package com.domain.devmovie.service;

import com.domain.devmovie.dto.RequestRegisterUser;
import com.domain.devmovie.dto.ResponseRegisterUser;

public interface RegisterService {
    ResponseRegisterUser register(RequestRegisterUser request);
}
