package com.example.bety.repository;

import com.example.bety.model.bdd.RoleModel;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<RoleModel, Long> {
}
