package com.example.bety.model.mapper;

import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.service.Person;

import java.util.stream.Collectors;

public class PersonMapper {

    RoleMapper roleMapper;

    PersonMapper(RoleMapper roleMapper){
        this.roleMapper = roleMapper;
    }

    public Person bdd2Service(PersonModel personModel) {
        return new Person(
                personModel.getId(),
                personModel.getName(),
                personModel.getFirstname(),
                personModel.getRoles().stream().map(role -> roleMapper.bdd2Service(role)).collect(Collectors.toList())
        );
    }

    public PersonModel service2Bdd(Person person) {
        return null;

    }
}
