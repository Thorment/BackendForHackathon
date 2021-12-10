package com.example.server.controller;

import com.example.server.entities.Level;
import com.example.server.entities.User;
import com.example.server.services.LevelsService;
import com.example.server.services.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ServersController {

    @Autowired
    private LevelsService levelsService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/levels")
    public @ResponseBody List<Level> getLevels() {
        return this.levelsService.getAll();
    }

    @GetMapping("/users")
    public @ResponseBody List<User> getUsers() {
        return this.usersService.getAll();
    }


    /**
     * GetMapping Erklärung
     * OHHH BOI LEGO > Playmobil.
     *
     * v             v /
     * http://localhost:8080/users
     */


    // clientseitig

    public class HTTPController {


        public List<User> getUsers() throws Exception{
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> list = new ArrayList<>();
            return Arrays.asList(objectMapper.readValue(getConnection("/users"), User.class));



        }

        public String getConnection(String urlToRead) throws Exception{

            StringBuilder stringBuilder= new StringBuilder();
            BufferedReader rd = null;

                URL url = new URL("http://localhost:8080" + urlToRead);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuilder.append(line);
                }
                rd.close();

                rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            return stringBuilder.toString();

        }



    }

}
