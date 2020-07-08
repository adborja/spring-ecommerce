package co.edu.cedesistemas.ecommerce.controller;


import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        Order found = orderService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
    @GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getOrderByIdItems(@PathVariable String id) {
        List<OrderItem> found = orderService.getItemsByIdOrder(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

}