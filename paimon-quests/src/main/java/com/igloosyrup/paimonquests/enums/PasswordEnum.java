package com.igloosyrup.paimonquests.enums;

public enum PasswordEnum {


    PBKDF2("pbkdf2");

    PasswordEnum(String stringValue){
        this.stringValue = stringValue;
    }

    private final String stringValue;

    public String getStringValue(){
        return stringValue;
    }
}
