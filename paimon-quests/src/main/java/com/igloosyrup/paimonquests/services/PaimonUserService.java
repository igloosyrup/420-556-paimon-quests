package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.enums.PasswordEnum;
import com.igloosyrup.paimonquests.models.Credentials;
import com.igloosyrup.paimonquests.models.PaimonUser;
import com.igloosyrup.paimonquests.repositories.PaimonUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaimonUserService {

    public PaimonUserRepository userRepository;

    private PasswordService passwordService;

    public PaimonUserService(PaimonUserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordService = new PasswordService(PasswordEnum.PBKDF2.getStringValue());
    }

    public Optional<PaimonUser> registerUser(PaimonUser user) {
        try {
            if (!validateUserRegistration(user))
                throw new Exception("missing a parameter");
            user.setPassword(passwordService.encodePassword(user.getPassword()));
            return Optional.of(userRepository.save(user));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<PaimonUser> loginUser(Credentials credentials) {
        try {
            String username = credentials.getUserName();
            String password = credentials.getPassword();
            PaimonUser user = userRepository.findPaimonUserByUserName(username);
            System.out.println(passwordService.matchPassword(password, user.getPassword()));
            return passwordService.matchPassword(password, user.getPassword()) ? Optional.of(user) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private boolean validateUserRegistration(PaimonUser paimonUser) {
        return !paimonUser.getUserName().isEmpty() && !paimonUser.getUserName().isBlank() &&
                !paimonUser.getPassword().isEmpty() && !paimonUser.getPassword().isBlank() &&
                !paimonUser.getEmail().isEmpty() && !paimonUser.getEmail().isBlank();
    }
}
