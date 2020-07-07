package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import co.edu.cedesistemas.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService uService;

    public UserController(final UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User o) {
        User created = uService.createUser(o);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User user) {
        User updated = uService.updateUser(user, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PostMapping("/users/addresses")
    public ResponseEntity<?> createAddress(@RequestBody Address a) {
        Address created = uService.createAddress(a);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User found = uService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/users/by-email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        User found = uService.getByEmail(email);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        Iterable<User> o = uService.getAllUser();

        if (o == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
