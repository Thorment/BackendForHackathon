package com.example.server.services;

import com.example.server.entities.Level;
import com.example.server.repositorys.LevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelsService {
    @Autowired
    private LevelsRepository levelsRepository;

    public List<Level> getAll(){
        return (List<Level>) this.levelsRepository.findAll();
    }
}
