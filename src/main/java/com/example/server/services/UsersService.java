package com.example.server.services;

import com.example.server.entities.Role;
import com.example.server.entities.User;
import com.example.server.entities.UserRegistrationForm;
import com.example.server.repositorys.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAll(){
        return (List<User>) this.usersRepository.findAll();
    }

    public User getUserById(int userId) {
        User user = (User) this.usersRepository.findById(userId).get();
        return user;
    }

    public boolean checkIfUserExists(User user) { return this.usersRepository.existsById(user.getIdNumber());}

    public void deleteUserIfExists(User user) { this.usersRepository.deleteById(user.getIdNumber());}

    public void ragnarok(){ this.usersRepository.deleteAll();}

    public boolean isAdmin(User user){
        return user.getRole() == Role.ADMIN ? true : false;
    }
    public boolean isAuthor(User user){
        return user.getRole() == Role.AUTHOR ? true : false ;
    }

    public void saveUser(UserRegistrationForm user) {
        //todo admincheck -> erweiterung um attr
        User user1 = new User();
        user1.setEMail(user.getEmailAdress());
        user1.setPassword(user.getPassword());
        user1.setUserName(user.getAlias());
        this.usersRepository.save(user1);
    }


}
