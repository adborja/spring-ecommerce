package co.edu.cedesistemas.ecommerce.controller;


import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User found = userService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/users/by-email")
    public ResponseEntity<?> getUsersByEmail(@RequestParam String email) {
        List<User> users = userService.getByEmail(email);
        return new ResponseEntity<>(users.get(0), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> UpdateEmail(@PathVariable("id") String id, @RequestBody User user) {
        User updated = userService.updateUserEmail(id, user);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
