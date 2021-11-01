package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.models.User;
import com.igloosyrup.paimonquests.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> registerUser(User user) {
        try {
            return Optional.of(userRepository.save(user));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<User> loginUser(String userName, String password) {
        try {
            return Optional.of(userRepository.findUserByUserNameAndPassword(userName, password));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
