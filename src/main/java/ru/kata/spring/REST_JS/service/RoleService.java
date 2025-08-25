package ru.kata.spring.REST_JS.service;

import ru.kata.spring.REST_JS.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleByName(String role);

    List<Role> getSetOfRoles(String[] roleNames);

    void addRole(Role role);

    void editRole(Role role);

    Role getById(Long id);
}
