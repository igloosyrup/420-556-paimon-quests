package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.enums.PasswordEnum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;


public class PasswordService {

    private Map<String, PasswordEncoder> encoders;

    private PasswordEncoder passwordEncoder;

    public PasswordService(String idEncode) {
        encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put(PasswordEnum.PBKDF2.getStringValue(), new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());

        passwordEncoder = new DelegatingPasswordEncoder(idEncode, encoders);
    }

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    public boolean matchPassword(String password, String encoded){
        return passwordEncoder.matches(password, encoded);
    }
}
