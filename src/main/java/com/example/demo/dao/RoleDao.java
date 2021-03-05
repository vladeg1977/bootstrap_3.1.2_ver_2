package com.example.demo.dao;

import com.example.demo.model.Role;

import java.util.List;

public interface RoleDao {
    public Role getRoleById (Long id);
    public List<Role> listRoles();
}
