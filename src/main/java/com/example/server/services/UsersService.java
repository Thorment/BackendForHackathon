package com.example.server.services;

import com.example.server.entities.User;
import com.example.server.repositorys.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAll(){
        return (List<User>) this.usersRepository.findAll();
    }
}
