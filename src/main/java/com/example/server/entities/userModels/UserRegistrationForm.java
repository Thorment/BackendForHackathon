package com.example.server.entities.userModels;

import lombok.Data;

@Data
public class UserRegistrationForm extends User {

    private String eMail;
    private String password;
    private String userName;



}
