package ru.kata.spring.REST_JS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.REST_JS.dao.RoleDao;
import ru.kata.spring.REST_JS.models.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }

    @Override
    public List<Role> getSetOfRoles(String[] roleNames) {
        return roleDao.getSetOfRoles(roleNames);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleDao.editRole(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }
}
