package com.example.bety.controller;

import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.bdd.RoleModel;
import com.example.bety.model.service.Person;
import com.example.bety.model.service.Role;
import com.example.bety.service.PersonService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

    @GetMapping("/getPerson/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Optional<Person> oPerson = personService.getPerson(id);

        if (oPerson.isEmpty()) {
            return new ResponseEntity<>(null, NOT_FOUND);
        }

        return new ResponseEntity<>(oPerson.get(), HttpStatus.OK);
    }

    @GetMapping("/deletePerson/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {

        final boolean bool = personService.deletePerson(id);

        if (!bool) {
            return new ResponseEntity<>(null, NOT_FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/addPerson/{a}/{b}/{c}")
    public ResponseEntity<Person> addPerson(@PathVariable String a, @PathVariable String b, @PathVariable String c) {
        List<Role> listRole = new ArrayList<>();
        final Person person = new Person(null, a, b, c, listRole);
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.OK);
    }

    @GetMapping("/updatePerson/{a}/{b}/{c}/{d}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long a, @PathVariable String b, @PathVariable String c, @PathVariable String d) {
        List<Role> listRole = new ArrayList<>();
        final Person person = new Person(a, b, c, d, listRole);
        return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
    }


    @GetMapping("/showAllPersons")
    public ResponseEntity<List<Person>> showAllPersons() {
        return new ResponseEntity<>(personService.showAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/showAllPersonsSorted")
    public ResponseEntity<List<Person>> showAllPersonsSorted() {
        return new ResponseEntity<>(personService.showAllPersonsSorted(), HttpStatus.OK);
    }

    @GetMapping("/showAllPersonsSortedLite")
    public ResponseEntity<List<Person>> showAllPersonsSortedLite() {
        return new ResponseEntity<>(personService.showAllPersonsSortedLite(), HttpStatus.OK);
    }
}

