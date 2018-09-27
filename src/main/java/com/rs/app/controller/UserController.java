package com.rs.app.controller;

import com.rs.app.model.User;
import com.rs.app.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api("UserController")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    @ApiOperation(value = "Default Welcome Message", httpMethod = "GET")
    public String welcome() {
        return "Welcome to Liquibase database migration tool";
    }
    @PostMapping("/regiser")
    @ApiOperation(value = "Register User", httpMethod = "POST", produces = "application/json")
    public ResponseEntity<User> registerUser(@RequestBody final User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok().body(savedUser);
    }
    @GetMapping("/all")
    @ApiOperation(value = "Display all users", httpMethod = "GET", produces = "application/json")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
