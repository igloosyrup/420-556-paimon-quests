package com.igloosyrup.paimonquests.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer idUser;

    @Column(unique = true, length = 20)
    private String userName;

    private String password;
    @Column(unique = true, length = 50)
    private String email;
    private String firstName;
    private String lastName;
    private String birthDate;

}
