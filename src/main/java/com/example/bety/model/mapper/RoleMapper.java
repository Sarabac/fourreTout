package com.example.bety.model.mapper;

import com.example.bety.model.bdd.RoleModel;
import com.example.bety.model.service.Role;
import org.springframework.stereotype.Component;


public class RoleMapper {
    public Role bdd2Service(RoleModel roleModel) {
        return roleModel != null
                ? new Role(roleModel.getId(), roleModel.getName())
                : null;
    }

    public RoleModel service2Bdd(Role role) {
        if (role == null) {
            return null;
        }

        RoleModel roleModel = new RoleModel();
        roleModel.setId(role.getId());
        roleModel.setName(role.getName());
        return roleModel;
    }
}
