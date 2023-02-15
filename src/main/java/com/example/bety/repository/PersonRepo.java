package com.example.bety.repository;

import com.example.bety.model.bdd.PersonModel;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<PersonModel, Long> {
}
