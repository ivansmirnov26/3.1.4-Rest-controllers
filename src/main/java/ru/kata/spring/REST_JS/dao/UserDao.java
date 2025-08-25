package ru.kata.spring.REST_JS.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.REST_JS.models.User;

import java.util.List;

@Repository
public interface UserDao {
    List<User> allUsers();

    User showUser(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void delUser(Long id);

    User findByUsername(String name);

    User findByUserEmail(String email);
}
