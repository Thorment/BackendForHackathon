package com.example.server.entities;

public class Author extends User{

    public Author(){
        super();
        this.setRole(Role.AUTHOR);
    }


}
