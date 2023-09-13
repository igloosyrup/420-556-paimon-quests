package com.igloosyrup.paimonquests.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igloosyrup.paimonquests.enums.PasswordEnum;
import com.igloosyrup.paimonquests.models.Credentials;
import com.igloosyrup.paimonquests.models.PaimonUser;
import com.igloosyrup.paimonquests.services.PasswordService;
import com.igloosyrup.paimonquests.services.PaimonUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.when;

import java.util.Optional;

@WebMvcTest(PaimonUserController.class)
public class PaimonUserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaimonUserService userService;

    private PasswordService passwordService;

    private Credentials credentials;
    private PaimonUser rawUser;
    private PaimonUser user;
    private PaimonUser invalidUser;
    private String rawPassword;
    private String encodedPassword;

    @BeforeEach
    public void setup() {
        passwordService = new PasswordService(PasswordEnum.PBKDF2.getStringValue());
        rawPassword = "toto";
        encodedPassword = passwordService.encodePassword(rawPassword);
        credentials = Credentials.builder()
                .userName("toto")
                .password(rawPassword)
                .build();

        rawUser = PaimonUser.builder()
                .idUser(1)
                .userName("toto")
                .password(rawPassword)
                .email("toto@toto.toto")
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
    public void testRegisterUser() throws Exception {
        when(userService.registerUser(rawUser)).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(post("/user/register").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(rawUser))).andReturn();

        var actualUser = new ObjectMapper().readValue(result.getResponse()
                .getContentAsString(), new TypeReference<PaimonUser>() {
        });

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void testRegisterUserFails() throws Exception {
        when(userService.registerUser(invalidUser)).thenReturn(Optional.empty());

        MvcResult result = mockMvc.perform(post("/user/register").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(new ObjectMapper().writeValueAsString(invalidUser))).andReturn();
        var actualUser = result.getResponse().getContentAsString();

        assertThat(actualUser).isEqualTo("");
    }

    @Test
    public void testLoginUser() throws Exception {
        when(userService.loginUser(credentials)).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(post("/user/login").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(rawUser))).andReturn();

        var actualUser = new ObjectMapper().readValue(result.getResponse()
                .getContentAsString(), new TypeReference<PaimonUser>() {
        });

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void testLoginUserFails() throws Exception {
        when(userService.loginUser(null)).thenReturn(Optional.empty());

        MvcResult result = mockMvc.perform(post("/user/login").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(new ObjectMapper().writeValueAsString(invalidUser))).andReturn();
        var actualUser = result.getResponse().getContentAsString();

        assertThat(actualUser).isEqualTo("");
    }

    @Test
    public void testGetToken() throws Exception {
        MvcResult result = mockMvc.perform(get("/user/token")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        var actualResult = new ObjectMapper().readValue(result.getResponse().getContentAsString(), new TypeReference<Boolean>() {
        });

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(actualResult).isTrue();
    }
}
