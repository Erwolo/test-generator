package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
