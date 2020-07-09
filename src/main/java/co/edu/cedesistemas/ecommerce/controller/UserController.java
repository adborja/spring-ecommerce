package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUsers(@RequestBody User user) {
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
       // Set<User> found = userService.getByEmail(email);
        User found = userService.getByEmail(email);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable String id,@RequestBody User user) {
        User userFound = userService.updateUser(id,user);
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }
}
