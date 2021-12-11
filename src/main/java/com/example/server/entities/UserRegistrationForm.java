package com.example.server.entities;

import lombok.Data;

@Data
public class UserRegistrationForm {


    private String emailAdress;
    private String password;
    private String alias;
}
