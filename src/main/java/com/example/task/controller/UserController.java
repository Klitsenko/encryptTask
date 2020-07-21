package com.example.task.controller;

import com.example.task.dto.UserDto;
import com.example.task.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }
}
