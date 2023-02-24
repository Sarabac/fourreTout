package com.example.bety.model.mapper;

import com.example.bety.model.MyList;
import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.bdd.RoleModel;
import com.example.bety.model.service.Person;
import com.example.bety.model.service.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class PersonMapper {

    RoleMapper roleMapper;

    public PersonMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public Person bdd2Service(PersonModel personModel) {
        if (personModel == null) {
            return null;
        }

        Base64.Decoder decoder = Base64.getDecoder();
        List<Role> roles = new ArrayList<>();


        final int a = personModel.getRoles().size();
        for (int i = 0; i < a; ++i) {

            roles.add(roleMapper.bdd2Service(personModel.getRoles().get(i)));
        }


        String decodedPassword = new String(decoder.decode(personModel.getPassword()));

        return new Person(
                personModel.getId(),
                personModel.getName(),
                personModel.getFirstname(),
                decodedPassword,
                //personModel.getPassword(),
                roles);
    }

    public PersonModel service2Bdd(Person person) {
        if (person == null) {
            return null;
        }

        Base64.Encoder encoder = Base64.getEncoder();
        PersonModel personModel = new PersonModel();
        List<RoleModel> roleModels = new ArrayList<>();


        personModel.setId(person.getId());
        personModel.setName(person.getName());
        personModel.setFirstname(person.getFirstname());

        String encodedPassword = encoder.encodeToString(person.getPassword().getBytes());
        personModel.setPassword(encodedPassword);

        final int a = person.getRoles().size();

        for (Role role : person.getRoles()) {
            roleModels.add(roleMapper.service2Bdd(role));
        }

        personModel.setRoles(roleModels);
        return personModel;
    }
}
