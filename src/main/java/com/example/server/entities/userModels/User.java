package com.example.server.entities.userModels;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Data
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
        this.eMail = urf.getEMail();
        this.password = urf.getPassword();
        this.userName = urf.getUserName();
    }

    public boolean isAdmin(){ return this.getRole() == Role.ADMIN ? true : false; }

    public boolean isAuthor(){ return this.getRole() == Role.AUTHOR ? true : false; }


}
