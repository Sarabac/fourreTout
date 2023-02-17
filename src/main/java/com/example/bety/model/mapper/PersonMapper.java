package com.example.bety.model.mapper;

import com.example.bety.model.MyList;
import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.bdd.RoleModel;
import com.example.bety.model.service.Person;
import com.example.bety.model.service.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    RoleMapper roleMapper;

    PersonMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public Person bdd2Service(PersonModel personModel) {
        if (personModel == null) {
            return null;
        }

        List<Role> roles = new ArrayList<>();

        final int a = personModel.getRoles().size();
        for (int i = 0; i < a; ++i) {

            roles.add(roleMapper.bdd2Service(personModel.getRoles().get(i)));
        }

        return new Person(
                personModel.getId(),
                personModel.getName(),
                personModel.getFirstname(),
                personModel.getPassword(),
                roles);
    }

    public PersonModel service2Bdd(Person person) {
        if (person == null) {
            return null;
        }

        PersonModel personModel = new PersonModel();
        List<RoleModel> roleModels = new ArrayList<>();

        personModel.setId(person.getId());
        personModel.setName(person.getName());
        personModel.setFirstname(person.getFirstname());
        personModel.setPassword(person.getPassword());
        final int a = person.getRoles().size();

        for (Role role : person.getRoles()) {
            roleModels.add(roleMapper.service2Bdd(role));
        }

        personModel.setRoles(roleModels);
        return personModel;
    }
}
