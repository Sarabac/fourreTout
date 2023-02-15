package com.example.bety.service;

import com.example.bety.model.service.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person getPerson(Long id) {
        return null;
    }

    public boolean addPerson(Person p) {
        return false;
    }

    public boolean deletePerson(Person p) {
        return false;
    }

    public Person updatePerson(Person p) {
        return p;
    }

}
