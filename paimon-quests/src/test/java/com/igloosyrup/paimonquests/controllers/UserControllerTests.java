package com.igloosyrup.paimonquests.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igloosyrup.paimonquests.models.User;
import com.igloosyrup.paimonquests.services.UserService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.when;

import java.util.Optional;

@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;
    private User invalidUser;

    @BeforeEach
    public void setup() {
        user = User.builder()
                .idUser(1)
                .userName("toto")
                .password("toto")
                .email("toto@toto.toto")
                .build();
        invalidUser = User.builder()
                .idUser(2)
                .userName("toto")
                .password("toto")
                .email("toto@toto.toto")
                .build();
    }

    @Test
    public void testRegisterUser() throws Exception {
        when(userService.registerUser(user)).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user))).andReturn();

        var actualUser = new ObjectMapper().readValue(result.getResponse()
                .getContentAsString(), new TypeReference<User>() {
        });

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void testRegisterUserFails() throws Exception {
        when(userService.registerUser(invalidUser)).thenReturn(Optional.empty());

        MvcResult result = mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(new ObjectMapper().writeValueAsString(invalidUser))).andReturn();
        var actualUser = result.getResponse().getContentAsString();

        assertThat(actualUser).isEqualTo("");
    }

    @Test
    public void testLoginUser() throws Exception {
        when(userService.loginUser(user.getUserName(), user.getPassword())).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(get("/user/login/" + user.getUserName() + "/" + user.getPassword())
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        var actualUser = new ObjectMapper().readValue(
                result.getResponse().getContentAsString(), new TypeReference<User>() {
                });

        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void testLoginUserFails() throws Exception {
        when(userService.loginUser(null, null)).thenReturn(Optional.empty());

        MvcResult result = mockMvc.perform(get("/user/login/null/null")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        var actualUser = result.getResponse().getContentAsString();

        assertThat(actualUser).isEmpty();
    }
}
