package ru.kata.spring.REST_JS.service;

import ru.kata.spring.REST_JS.models.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    User showUser(Long id);

    void saveUser(User user);

    void updateUser(Long id, User user);

    void delUser(Long id);

    User findByUsername(String name);

    User findByUserEmail(String email);
}
