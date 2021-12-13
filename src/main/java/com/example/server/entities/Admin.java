package com.example.server.entities;

public class Admin extends User{

    public Admin(){
        super();
        this.setRole(Role.ADMIN);
    }


}
