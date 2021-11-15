package com.igloosyrup.paimonquests.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Credentials {

    private String userName;
    private String password;
}
