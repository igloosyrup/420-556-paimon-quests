package com.igloosyrup.paimonquests.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Transient
    private final int USERNAME_LENGTH = 20;
    @Transient
    private final int EMAIL_LENGTH = 50;
    @Id
    @GeneratedValue
    private Integer idUser;
    @Column(unique = true, length = USERNAME_LENGTH)
    private String userName;
    private String password;
    @Column(unique = true, length = EMAIL_LENGTH)
    private String email;
}
