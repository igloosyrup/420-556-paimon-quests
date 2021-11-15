package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.enums.PasswordEnum;
import com.igloosyrup.paimonquests.models.Credentials;
import com.igloosyrup.paimonquests.models.User;
import com.igloosyrup.paimonquests.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public UserRepository userRepository;

    private PasswordService passwordService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordService = new PasswordService(PasswordEnum.PBKDF2.getStringValue());
    }

    public Optional<User> registerUser(User user) {
        try {
            user.setPassword(passwordService.encodePassword(user.getPassword()));
            return Optional.of(userRepository.save(user));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<User> loginUser(Credentials credentials) {
        try {
            String username = credentials.getUserName();
            String password = credentials.getPassword();
            User user = userRepository.findUserByUserName(username);
            System.out.println(passwordService.matchPassword(password, user.getPassword()));
            return passwordService.matchPassword(password, user.getPassword()) ? Optional.of(user) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
