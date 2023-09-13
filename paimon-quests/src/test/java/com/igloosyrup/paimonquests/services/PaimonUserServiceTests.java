package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.enums.PasswordEnum;
import com.igloosyrup.paimonquests.models.Credentials;
import com.igloosyrup.paimonquests.models.PaimonUser;
import com.igloosyrup.paimonquests.repositories.PaimonUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PaimonUserServiceTests {

    @Mock
    private PaimonUserRepository paimonUserRepository;

    @InjectMocks
    private PaimonUserService paimonUserService;

    private PasswordService passwordService;
    private Credentials credentials;
    private PaimonUser user;
    private PaimonUser invalidUser;
    private String rawPassword;
    private String encodedPassword;

    @BeforeEach
    public void setup(){
        passwordService = new PasswordService(PasswordEnum.PBKDF2.getStringValue());
        rawPassword = "toto";
        encodedPassword = passwordService.encodePassword(rawPassword);
        credentials = Credentials.builder()
                .userName("toto")
                .password(rawPassword)
                .build();

        user = PaimonUser.builder()
                .idUser(1)
                .userName("toto")
                .password(encodedPassword)
                .email("toto@toto.toto")
                .build();
        invalidUser = PaimonUser.builder()
                .idUser(2)
                .userName("toto")
                .password(encodedPassword)
                .email("toto@toto.toto")
                .build();
    }

    @Test
    public void testRegisterUser(){
        when(paimonUserRepository.save(user)).thenReturn(user);
        Optional<PaimonUser> actualUser = paimonUserService.registerUser(user);
        assertThat(actualUser.get()).isEqualTo(user);
        assertThat(actualUser.get().getIdUser()).isEqualTo(user.getIdUser());
    }

    @Test
    public void testRegisterUserFails(){
        when(paimonUserRepository.save(invalidUser)).thenReturn(null);
        Optional<PaimonUser> actualUser = paimonUserService.registerUser(invalidUser);
        assertThat(actualUser).isEmpty();
    }

    @Test
    public void testLoginUser(){
        when(paimonUserRepository.findPaimonUserByUserName(user.getUserName())).thenReturn(user);
        Optional<PaimonUser> actualUser = paimonUserService.loginUser(credentials);
        assertThat(actualUser.get()).isEqualTo(user);
        assertThat(actualUser.get().getIdUser()).isEqualTo(user.getIdUser());
    }

    @Test
    public void testLoginUserFails(){
        lenient().when(paimonUserRepository.findPaimonUserByUserName(null)).thenReturn(null);
        Optional<PaimonUser> actualUser = paimonUserService.loginUser(null);
        assertThat(actualUser).isEmpty();
    }

    @Test
    public void testToken(){
        CsrfTokenRepository tokenRepository;
        CsrfToken token;
    }

}
