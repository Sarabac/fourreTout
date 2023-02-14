package com.example.bety.Model;

import lombok.Data;

import javax.persistence.*;
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
    List<RoleModel> roles;
}
