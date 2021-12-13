package com.example.server.entities.userModels;

public class Admin extends User {

    public Admin(){
        super();
        this.setRole(Role.ADMIN);
    }


}
