package com.example.bety.model.bdd;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstname;

    @ManyToMany(mappedBy = "persons")
    List<RoleModel> roles = new ArrayList<>();
}
