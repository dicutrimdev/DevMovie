package com.domain.devmovie.controllers;

import lombok.RequiredArgsConstructor;
import com.domain.devmovie.entities.User;
import org.springframework.http.HttpStatus;
import com.domain.devmovie.dto.RequestUserDto;
import com.domain.devmovie.dto.ResponseUserDto;
import com.domain.devmovie.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody RequestUserDto dto) {
        var createdUser = userService.createUser(dto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "/search")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        var user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
