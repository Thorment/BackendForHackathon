package com.example.server.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Levels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int test;

}
