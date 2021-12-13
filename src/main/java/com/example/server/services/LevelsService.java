package com.example.server.services;

import com.example.server.entities.levelModels.Level;
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

    public Level getLevelById(int id) {
        Level level = (Level) this.levelsRepository.findById(id).get();
        return level;
    }

    public void save(Level level) {
        this.levelsRepository.save(level);
    }
}
