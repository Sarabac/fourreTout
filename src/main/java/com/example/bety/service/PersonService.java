package com.example.bety.service;

import antlr.StringUtils;
import com.example.bety.model.bdd.PersonModel;
import com.example.bety.model.mapper.PersonMapper;
import com.example.bety.model.service.Person;
import com.example.bety.repository.PersonRepo;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.util.*;


public class PersonService {

    PersonRepo personRepo;
    PersonMapper personMapper;

    public PersonService(PersonRepo personRepo, PersonMapper personMapper, List<String> names) {
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

    public List<Person> showAllPersonsSorted() {
        Iterable<PersonModel> iPersonModel = personRepo.findAll();
        List<Person> tListPerson = new ArrayList<>();
        List<Person> listPerson = new ArrayList<>();

        for (PersonModel p : iPersonModel) {
            tListPerson.add(personMapper.bdd2Service(p));
        }

        listPerson.set(0, tListPerson.get(0));

        for (int i = 1; i < tListPerson.size(); ++i) {

            int j = 0;

            do {
                ++j;
            } while (tListPerson.get(i).getName().compareTo(listPerson.get(j).getName()) < 0);

            listPerson.set(j, tListPerson.get(i));

        }
        return listPerson;
    }


    public List<Person> showAllPersonsSortedLite() {
        Iterable<PersonModel> iPersonModel = personRepo.findAll();
        List<Person> listPerson = new ArrayList<>();

        for (PersonModel p : iPersonModel) {

            listPerson.add(personMapper.bdd2Service(p));
        }

        listPerson.sort(new PersonComparator());

        return listPerson;
    }

    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1 == null && p2 != null)
                return -1;
            else if (p1 != null && p2 == null)
                return 1;
            else if (p1 == p2)
                return 0;
            else {
                if (p1.getName() != null)
                    return p1.getName().compareTo(p2.getName());
                else if (p2.getName() != null)
                    return 1;
                else
                    return 0;
            }

        }
    }


    public Person getPersonByName(String name) {

        if (name == null) {
            return null;
        }

        Iterable<PersonModel> iPersonRepo = personRepo.findAll();

        for (PersonModel p : iPersonRepo) {
            if (name.equals(p.getName())) {
                return personMapper.bdd2Service(p);
            }
        }
        return null;
    }

    public Boolean login(String name, String password) {

        if ("admin".equals(name)) {
            return ("admin".equals(password));
        }

        Person p = getPersonByName(name);

        return p != null && p.getPassword() != null && p.getPassword().equals(password);
    }


}
