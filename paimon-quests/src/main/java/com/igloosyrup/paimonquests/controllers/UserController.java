package com.igloosyrup.paimonquests.controllers;

import com.igloosyrup.paimonquests.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
public class UserController {

    public UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }



}
