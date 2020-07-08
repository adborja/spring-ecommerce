package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
