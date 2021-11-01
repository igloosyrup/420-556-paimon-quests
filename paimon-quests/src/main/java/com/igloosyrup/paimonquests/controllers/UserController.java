package com.igloosyrup.paimonquests.controllers;

import com.igloosyrup.paimonquests.models.User;
import com.igloosyrup.paimonquests.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        return userService.registerUser(newUser)
                .map(user1 -> ResponseEntity.status(HttpStatus.CREATED).body(user1))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/login/{userName}/{password}")
    public ResponseEntity<User> loginUser(@PathVariable String userName, @PathVariable String password){
        return userService.loginUser(userName, password)
                .map(user1 -> ResponseEntity.status(HttpStatus.OK).body(user1))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
