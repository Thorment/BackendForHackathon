package com.example.server.controller;

import com.example.server.entities.Levels;
import com.example.server.entities.Users;
import com.example.server.services.LevelsService;
import com.example.server.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ServerController {

    @Autowired
    private LevelsService levelsService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/levels")
    public @ResponseBody List<Levels> getLevels() {
        return this.levelsService.getAll();
    }

    @GetMapping("/users")
    public @ResponseBody List<Users> getUsers() {
        return this.usersService.getAll();
    }

}
