package com.example.bety.repository;

import com.example.bety.Model.PersonModel;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<PersonModel, Long> {
}
