package com.example.server.repositorys;

import com.example.server.entities.Levels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelsRepository extends CrudRepository<Levels,Integer> {
}
