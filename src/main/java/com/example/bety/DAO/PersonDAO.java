package com.example.bety.DAO;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PERSON")
public class PersonDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstname;

}
