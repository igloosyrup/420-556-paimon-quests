package com.igloosyrup.paimonquests.controllers;

import com.igloosyrup.paimonquests.models.Credentials;
import com.igloosyrup.paimonquests.models.PaimonUser;
import com.igloosyrup.paimonquests.services.PaimonUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@EnableWebSecurity(debug = true)
@CrossOrigin(origins = "http://localhost:4000", allowCredentials = "true")
@RequestMapping("/user")
public class PaimonUserController {

    public PaimonUserService userService;

    public PaimonUserController(PaimonUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<PaimonUser> registerUser(@RequestBody PaimonUser newUser) {
        System.out.println(newUser);
        return userService.registerUser(newUser)
                .map(user1 -> ResponseEntity.status(HttpStatus.CREATED).body(user1))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/login")
    public ResponseEntity<PaimonUser> loginUser(@RequestBody Credentials credentials) {
        System.out.println(credentials);
        return userService.loginUser(credentials)
                .map(user1 -> ResponseEntity.status(HttpStatus.OK).body(user1))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/token")
    public ResponseEntity<Boolean> getToken() {
        return Optional.of(Boolean.TRUE)
                .map(aBoolean -> ResponseEntity.status(HttpStatus.OK).body(aBoolean))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

}
