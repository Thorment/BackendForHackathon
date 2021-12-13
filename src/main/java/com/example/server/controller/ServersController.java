package com.example.server.controller;

import com.example.server.entities.Admin;
import com.example.server.entities.User;
import com.example.server.entities.UserRegistrationForm;
import com.example.server.services.LevelsService;
import com.example.server.services.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ServersController {

    @Autowired
    private LevelsService levelsService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/api/levels")
    public @ResponseBody ResponseEntity getLevels() {
        return ResponseEntity.status(200).body(this.levelsService.getAll());
    }

    @GetMapping("/api/users")
    public @ResponseBody ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(this.usersService.getAll());
    }

    @GetMapping("/api/userByID")
    public @ResponseBody ResponseEntity getUserByID(Integer id) {
        User user = usersService.getUserById(id);
        System.out.println("Benutzerkram name :" + user.getUserName() + "password lulu" + user.getPassword() );
        return ResponseEntity.status(200).body(this.usersService.getUserById(id));
    }

    @PostMapping("/api/userCreation")
    public @ResponseBody ResponseEntity createUser(@RequestBody UserRegistrationForm user) {
        if (false) { //Datenbankabfrage ob es den User bereits gibt
            return ResponseEntity.status(409).build();
        } else {

            usersService.saveUser(user);
            return ResponseEntity.status(200).build();
        }

    }



    /**
     * GetMapping Erklärung
     * OHHH BOI LEGO > Playmobil.
     *
     * v             v /
     * http://localhost:8080/users
     *
     * localhost:8080 -> swagger url in der applicationproperties
     *
     *
     * Post ->      Neue Dinge erzeugen
     *
     * Get ->       Bestehende Dinge abfragen
     *
     * Put ->       Bestehe Dinge manipulieren
     *
     * Delete ->    Dinge löschen (zb Sessions Cookies bei Logout)
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
