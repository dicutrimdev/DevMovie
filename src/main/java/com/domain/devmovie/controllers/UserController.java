package com.domain.devmovie.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.domain.devmovie.dto.ResponseUserDto;
import com.domain.devmovie.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User")
@RequiredArgsConstructor

@RestController
@RequestMapping(value = "/api/users")
public class UserController {


    private final UserService userService;


    @GetMapping(value = "/{id}")
    @Operation(
            summary = "Retrieve a user by ID",
            description = "Fetch a user's details by providing the user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ResponseUserDto> getUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping(value = "/search")
    @Operation(
            summary = "Retrieve a user by email",
            description = "Fetch a user's details by providing the email address.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ResponseUserDto> getUserByEmail(@RequestParam String email) {
        var user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Delete a user by ID",
            description = "Delete a user from the system by providing the user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
