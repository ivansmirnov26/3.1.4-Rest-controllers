package ru.kata.spring.REST_JS.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.REST_JS.models.Role;

import java.util.List;

@Repository
public interface RoleDao {
    public List<Role> getAllRoles();

    public Role getRoleByName(String role);

    public List<Role> getSetOfRoles(String[] roleNames);

    public void addRole(Role role);

    public void editRole(Role role);

    public Role getById(Long id);
}
