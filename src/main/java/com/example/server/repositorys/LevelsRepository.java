package com.example.server.repositorys;

import com.example.server.entities.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelsRepository extends CrudRepository<Level,Integer> {
}

// Create - Read - update - delete = CRUD