package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


}
