package com.example.server.repositorys;

import com.example.server.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User,Integer> {
}
// Create - Read - update - delete = CRUD