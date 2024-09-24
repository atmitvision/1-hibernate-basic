package com.atmitvision.restapicruddemo.dao;

import com.atmitvision.restapicruddemo.entity.Role;

public interface RoleDao {
    Role findByRoleName(String roleName);
}
