package com.igloosyrup.paimonquests.services;

import com.igloosyrup.paimonquests.enums.PasswordEnum;
import com.igloosyrup.paimonquests.models.User;
import com.igloosyrup.paimonquests.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private PasswordService passwordService;

    private User user;
    private User invalidUser;
    private String rawPassword;
    private String encodedPassword;

    @BeforeEach
    public void setup(){
        passwordService = new PasswordService(PasswordEnum.PBKDF2.getStringValue());
        rawPassword = "toto";
        encodedPassword = passwordService.encodePassword(rawPassword);

        user = User.builder()
                .idUser(1)
                .userName("toto")
                .password(encodedPassword)
                .email("toto@toto.toto")
                .build();
        invalidUser = User.builder()
                .idUser(2)
                .userName("toto")
                .password(encodedPassword)
                .email("toto@toto.toto")
                .build();
    }

    @Test
    public void testRegisterUser(){
        when(userRepository.save(user)).thenReturn(user);
        Optional<User> actualUser = userService.registerUser(user);
        assertThat(actualUser.get()).isEqualTo(user);
        assertThat(actualUser.get().getIdUser()).isEqualTo(user.getIdUser());
    }

    @Test
    public void testRegisterUserFails(){
        when(userRepository.save(invalidUser)).thenReturn(null);
        Optional<User> actualUser = userService.registerUser(invalidUser);
        assertThat(actualUser).isEmpty();
    }

    @Test
    public void testLoginUser(){
        when(userRepository.findUserByUserName(user.getUserName())).thenReturn(user);
        Optional<User> actualUser = userService.loginUser(user.getUserName(), rawPassword);
        assertThat(actualUser.get()).isEqualTo(user);
        assertThat(actualUser.get().getIdUser()).isEqualTo(user.getIdUser());
    }

    @Test
    public void testLoginUserFails(){
        when(userRepository.findUserByUserName(null)).thenReturn(null);
        Optional<User> actualUser = userService.loginUser(null, null);
        assertThat(actualUser).isEmpty();
    }

}
