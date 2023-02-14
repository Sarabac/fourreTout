package com.example.bety.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "assigned",
            joinColumns = @JoinColumn(name= "role_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<PersonModel> persons = new ArrayList<>();
}
