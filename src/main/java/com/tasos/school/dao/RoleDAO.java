package com.tasos.school.dao;

import com.tasos.school.entity.Role;

public interface RoleDAO {
    public Role findRoleByName(String theRoleName);
}
