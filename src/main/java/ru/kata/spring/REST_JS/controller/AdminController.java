package ru.kata.spring.REST_JS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.REST_JS.models.User;
import ru.kata.spring.REST_JS.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> pageDelete(@PathVariable("id") long id) {
        userService.delUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.showUser(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByUsername(Principal principal) {
        User user = userService.findByUserEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> pageEdit(@PathVariable("id") long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }
}
