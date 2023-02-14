package com.example.bety.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String firstname;

    private List<Role> roles;
}
