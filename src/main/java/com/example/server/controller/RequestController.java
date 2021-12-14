package com.example.server.controller;

import com.example.server.entities.levelModels.Level;
import com.example.server.entities.userModels.Role;
import com.example.server.entities.userModels.UserRegistrationForm;
import com.example.server.services.LevelsService;
import com.example.server.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * localhost:8080 -> swagger url in der applicationproperties
 *
 * Post ->      Neue Dinge erzeugen
 *
 * Get ->       Bestehende Dinge abfragen
 *
 * Put ->       Bestehe Dinge manipulieren
 *
 * Delete ->    Dinge löschen (zb Sessions Cookies bei Logout)
 *
 */


@RestController
@CrossOrigin(origins = { "null" })
public class RequestController {

    @Autowired
    private LevelsService levelsService;
    @Autowired
    private UsersService usersService;


    @GetMapping("/api/users")
    public @ResponseBody ResponseEntity getUsers() { return ResponseEntity.status(200).body(this.usersService.getAll()); }

     @GetMapping("/api/userById")
    public @ResponseBody ResponseEntity getUserByID(Integer id) { return ResponseEntity.status(200).body(this.usersService.getUserById(id)); }


    @GetMapping("/api/userByRole")
    public @ResponseBody ResponseEntity getUserByRole(Role role) { return ResponseEntity.status(200).body(this.usersService.getUserByRole(role)); }

    @PostMapping("/api/userByEmailAndPassword")
    public @ResponseBody ResponseEntity getUserByEmailAndPassword(@RequestBody UserRegistrationForm user) {
        if (!usersService.isUserLoginValid(user)) {
            return ResponseEntity.status(409).build();
        } else {
            return ResponseEntity.status(200).build();
        }
    }

    @PostMapping("/api/createUser")
    public @ResponseBody ResponseEntity createUser(@RequestBody UserRegistrationForm user) {
       if (usersService.checkIfUserExistsAndGetUser(user).isPresent()) {
            return ResponseEntity.status(409).build();
        } else {
            usersService.saveUser(user);
            return ResponseEntity.status(200).build();
        }
    }


    @GetMapping("/api/levels")
    public @ResponseBody ResponseEntity getLevels() { return ResponseEntity.status(200).body(this.levelsService.getAll()); }


    @GetMapping("/api/level")
    public @ResponseBody ResponseEntity getLevel(int id) { return ResponseEntity.status(200).body(this.levelsService.getLevelById(id)); }


    @GetMapping("/api/checkLevel")
    public @ResponseBody ResponseEntity checkLevel(Level level) { return ResponseEntity.status(200).body(this.levelsService.checkLevelhasPassed(level)); }


    @PostMapping("/api/createLevel")
    public @ResponseBody ResponseEntity createLevel(@RequestBody Level level) {
        //TODO Abfrage ob schon vorhanden
        levelsService.save(level);
        return ResponseEntity.status(200).build();
    }




}
