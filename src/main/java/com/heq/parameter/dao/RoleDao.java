package com.heq.parameter.dao;


import com.heq.parameter.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> findRoleByMap(Map<String, String> params);
}
