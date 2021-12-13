package com.example.server.entities.userModels;

public class Author extends User {

    public Author(){
        super();
        this.setRole(Role.AUTHOR);
    }


}
