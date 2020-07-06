package co.edu.cedesistemas.ecommerce.controller;


import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(final UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User found = userService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
    @GetMapping("/users/by-email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        List<User> found = userService.getByEmail(email);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable String id,@RequestBody User user) {
        User found = userService.updateUser(id,user);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }


}
