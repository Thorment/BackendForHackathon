package com.example.server.entities.userModels;

import lombok.Data;

@Data
public class UserRegistrationForm extends User {

    private String emailAdress;
    private String password;
    private String alias;



}
