package com.example.bety.service;

import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.mapper.PersonMapper;
import com.example.bety.model.service.Person;
import com.example.bety.repository.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    PersonRepo personRepo;
    PersonMapper personMapper;

    PersonService(PersonRepo personRepo, PersonMapper personMapper) {
        this.personRepo = personRepo;
        this.personMapper = personMapper;
    }

    public Optional<Person> getPerson(Long id) {
        Optional<PersonModel> oPersonModel = personRepo.findById(id);
        return oPersonModel.map(personModel -> personMapper.bdd2Service(personModel));
    }

    public Person addPerson(Person p) {
        PersonModel personModel = personMapper.service2Bdd(p);
        personModel.setId(null);
        PersonModel result = personRepo.save(personModel);
        return personMapper.bdd2Service(result);
    }

    public boolean deletePerson(Long id) {
        if (personRepo.existsById(id)) {
            personRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public Person updatePerson(Person p) {
        PersonModel personModel = personMapper.service2Bdd(p);
        PersonModel result = personRepo.save(personModel);
        return personMapper.bdd2Service(result);
    }

    public List<Person> showAllPersons() {

        Iterable<PersonModel> iPersonModel = personRepo.findAll();
        List<Person> listPerson = new ArrayList<>();
        for (PersonModel p : iPersonModel) {
            listPerson.add(personMapper.bdd2Service(p));
        }
        return listPerson;
    }
}
