package com.example.server.services;

import com.example.server.entities.userModels.Role;
import com.example.server.entities.userModels.User;
import com.example.server.entities.userModels.UserRegistrationForm;
import com.example.server.repositorys.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAll(){
        return (List<User>) this.usersRepository.findAll();
    }

    public void deleteUserIfExists(User user) { this.usersRepository.deleteById(user.getIdNumber()); }

    public void ragnarok(){ this.usersRepository.deleteAll(); }


    /**
     * change return to optional
     * reason: two possible return values -> boolean if exits in db & matched user from db
     * optional.getPresent()  -> boolean
     * optional.get()         -> object
     *
     */
    public Optional<User> checkIfUserExistsAndGetUser(UserRegistrationForm formUser) {
        User userDb = null;
        for (User u : getAll()) {
            if (formUser.getEMail().equals(u.getEMail())) {
                userDb = u;
            }
        }
        return Optional.ofNullable(userDb);
    }

    public boolean isUserLoginValid(UserRegistrationForm formUser) {
        Optional<User> opUser = checkIfUserExistsAndGetUser(formUser);
        boolean valid = false;
        if (opUser.isPresent()) {
            User dbUser = opUser.get();
            valid = dbUser.getEMail().equals(formUser.getEMail()) && dbUser.getPassword().equals(formUser.getPassword());
        }
        return valid;
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
