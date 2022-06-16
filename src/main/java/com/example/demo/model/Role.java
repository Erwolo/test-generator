package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private HashSet<Permission> permissions;

}
