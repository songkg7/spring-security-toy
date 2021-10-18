package com.toy.springsecuritycore.service;

import com.toy.springsecuritycore.domain.entity.Role;
import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}