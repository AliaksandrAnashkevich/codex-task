package com.codex.service.impl;

import com.codex.entity.Role;
import com.codex.entity.enums.UsersRole;
import com.codex.repository.RoleRepository;
import com.codex.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getUserRole() {
        return roleRepository.findByName(UsersRole.USER.getRole());
    }

    @Override
    public Role getAdminRole() {
        return roleRepository.findByName(UsersRole.ADMIN.getRole());
    }
}
