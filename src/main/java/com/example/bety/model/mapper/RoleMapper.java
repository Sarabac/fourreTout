package com.example.bety.model.mapper;

import com.example.bety.model.bdd.RoleModel;
import com.example.bety.model.service.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role bdd2Service(RoleModel roleModel) {
        return new Role(roleModel.getId(),
                roleModel.getName()
        );
    }

    public RoleModel service2Bdd(Role role) {
        RoleModel roleModel = new RoleModel();
        roleModel.setId(role.getId());
        roleModel.setName(role.getName());
        return roleModel;
    }
}
