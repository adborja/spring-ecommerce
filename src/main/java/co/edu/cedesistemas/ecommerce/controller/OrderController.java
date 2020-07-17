package co.edu.cedesistemas.ecommerce.controller;


import co.edu.cedesistemas.ecommerce.model.document.*;
import co.edu.cedesistemas.ecommerce.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final UserService userService;
    private final StoreService storeService;
    private final AddressService addressService;
    private final ProductService productService;
    private final OrderService orderService;

    public OrderController(final UserService userService, StoreService storeService, AddressService addressService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.storeService = storeService;
        this.addressService = addressService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostMapping("/stores")
    public ResponseEntity<?> createStore(@RequestBody Store store) {
        Store created = storeService.createStore(store);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/users/addresses")
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        Address created = addressService.createAddress(address);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/products")
    public ResponseEntity<?> createAddress(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createAddress(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        Order found = orderService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/users/by-email")
    public ResponseEntity<?> getUserByMail(@RequestParam String email) {
        List<User> users = userService.getByMail(email);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


}