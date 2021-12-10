package com.example.server.services;

import com.example.server.entities.Levels;
import com.example.server.entities.Users;
import com.example.server.repositorys.LevelsRepository;
import com.example.server.repositorys.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAll(){
        return (List<Users>) this.usersRepository.findAll();
    }
}
