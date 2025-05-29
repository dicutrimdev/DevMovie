package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.domain.devmovie.dto.ResponseUserDto;
import com.domain.devmovie.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController {


    private final UserService userService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseUserDto> getUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "/search")
    public ResponseEntity<ResponseUserDto> getUserByEmail(@RequestParam String email) {
        var user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
