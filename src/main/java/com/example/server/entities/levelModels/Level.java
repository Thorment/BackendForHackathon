package com.example.server.entities.levelModels;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private Subject subject;
    private Integer recommendedTime;
    private Difficulty difficulty;

}
