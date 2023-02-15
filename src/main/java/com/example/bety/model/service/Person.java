package com.example.bety.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String firstname;

    private String password;

    private List<Role> roles;
}
