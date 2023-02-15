package com.example.bety.model.mapper;

import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.service.Person;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
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
                personModel.getRoles().stream().map(
                        rolebdd -> roleMapper.bdd2Service(rolebdd)
                ).collect(Collectors.toList())
        );
    }

    public PersonModel service2Bdd(Person person) {
        PersonModel personModel = new PersonModel();
        personModel.setId(person.getId());
        personModel.setName(person.getName());
        personModel.setFirstname(person.getFirstname());
        personModel.setRoles(
                person.getRoles().stream().map(role -> roleMapper.service2Bdd(role)).collect(Collectors.toList())
        );
        return personModel;

    }
}
