package com.example.server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idNumber;
    private String userName;
    private String eMail;
    private String password;
    private Role role;
    private Integer exp;
    private Integer level;


    public User(UserRegistrationForm urf) {
        this.eMail = urf.getEmailAdress();
        this.password = urf.getPassword();
        this.userName = urf.getAlias();
    }


    public boolean isAdmin(){
        return this.getRole() == Role.ADMIN ? true : false;
    }
    public boolean isAuthor(){
        return this.getRole() == Role.AUTHOR ? true : false;
    }
    public boolean isUser(){
        return this.getRole() == Role.USER ? true : false;
    }



}
