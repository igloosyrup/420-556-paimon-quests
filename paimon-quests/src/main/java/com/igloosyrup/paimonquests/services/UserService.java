package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
