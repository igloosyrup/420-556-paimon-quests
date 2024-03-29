package com.igloosyrup.paimonquests.controllers;

import com.igloosyrup.paimonquests.models.Credentials;
import com.igloosyrup.paimonquests.models.User;
import com.igloosyrup.paimonquests.repositories.UserRepository;
import com.igloosyrup.paimonquests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    //TODO delete after testing
    @Autowired
    public UserRepository userRepository;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        System.out.println(newUser);
        return userService.registerUser(newUser)
                .map(user1 -> ResponseEntity.status(HttpStatus.CREATED).body(user1))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody Credentials credentials){
        System.out.println(credentials);
        return userService.loginUser(credentials)
                .map(user1 -> ResponseEntity.status(HttpStatus.OK).body(user1))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    //TODO delete after testing
    @GetMapping("/{id}")
    public ResponseEntity<User> someGetMethod(@PathVariable Integer id){
        return userRepository.findById(id)
                .map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
