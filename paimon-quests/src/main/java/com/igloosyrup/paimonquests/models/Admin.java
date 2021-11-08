package com.igloosyrup.paimonquests.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Admin {
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
    private String firstName;
    private String lastName;
}
