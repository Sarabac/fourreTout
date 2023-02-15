package com.example.bety.model.mapper;

import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.service.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    PersonModel pBdd;
    Person pService;

    PersonMapper personMapper = new PersonMapper(new RoleMapper());



    @BeforeEach
    void setup(){
        pBdd = new PersonModel();
        pBdd.setId(Long.getLong("1"));
        pBdd.setName("aa");
        pBdd.setFirstname("bb");

        pService = new Person(
                Long.getLong("1"),
                "aa",
                "bb",
                new ArrayList<>()
        );
    }
    @Test
    void bdd2Service() {
        Person person = personMapper.bdd2Service(pBdd);
        assertEquals(pService,person);
    }

    @Test
    void service2Bdd() {
        PersonModel personModel = personMapper.service2Bdd(pService);
        assertEquals(pBdd, personModel);

    }
}