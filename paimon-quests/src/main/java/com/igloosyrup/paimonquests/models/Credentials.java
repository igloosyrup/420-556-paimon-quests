package com.igloosyrup.paimonquests.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserCredentials {

    private String username;
    private String password;
}
