package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.repositories.AdminRepository;
import com.igloosyrup.paimonquests.repositories.PaimonUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    private PaimonUserRepository paimonUserRepository;

    public AdminService(AdminRepository adminRepository, PaimonUserRepository paimonUserRepository) {
        this.adminRepository = adminRepository;
        this.paimonUserRepository = paimonUserRepository;
    }

    public Optional<Boolean> deleteUser(Integer userId){
        paimonUserRepository.deleteById(userId);
        return Optional.of(paimonUserRepository.findById(userId).isEmpty());
    }
}
