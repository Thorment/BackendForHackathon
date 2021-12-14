package com.example.server.services;

import com.example.server.entities.userModels.Role;
import com.example.server.entities.userModels.User;
import com.example.server.entities.userModels.UserRegistrationForm;
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

    //FIXME Übergebener User hat prinzipiell noch keine ID in dem Statium
    public boolean checkIfUserExists(User user) { return this.usersRepository.existsById(user.getIdNumber()); }

    public void deleteUserIfExists(User user) { this.usersRepository.deleteById(user.getIdNumber()); }

    public void ragnarok(){ this.usersRepository.deleteAll(); }

     public Boolean isUsernamePasswordCombinationValid(UserRegistrationForm user) {
        for (User user2 : getAll()) {
            if (user2.getEMail().equals(user.getEMail()) && user2.getPassword().equals(user.getPassword())) {
                return true;
            } else return false;
        }return false;
    }

    public User getUserById(int userId) {
        User user = (User) this.usersRepository.findById(userId).get();
        return user;
    }

    public User getUserByRole(Role role) {
        for (User user : getAll()) {
            if (user.getRole().equals(role)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(UserRegistrationForm user) {
        User insertUser = new User();
        insertUser.setEMail(user.getEMail());
        insertUser.setPassword(user.getPassword());
        insertUser.setUserName(user.getUserName());
        insertUser.setRole(Role.USER);
        insertUser.setExp(0);
        insertUser.setLevel(0);
        this.usersRepository.save(insertUser);
    }


}
