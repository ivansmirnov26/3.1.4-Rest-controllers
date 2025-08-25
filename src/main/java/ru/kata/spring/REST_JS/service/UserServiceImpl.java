package ru.kata.spring.REST_JS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.REST_JS.dao.UserDao;
import ru.kata.spring.REST_JS.models.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
        if (!user.getPassword().equals(userDao.showUser(id).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void delUser(Long id) {
        userDao.delUser(id);
    }

    @Override
    public User findByUsername(String name) {
        return userDao.findByUsername(name);
    }

    @Override
    public User findByUserEmail(String email) {
        return userDao.findByUserEmail(email);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByUserEmail(email);
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}
