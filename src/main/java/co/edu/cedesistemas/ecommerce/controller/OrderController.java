package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {
    private final OrderService orderService;

    public OrderController (final OrderService orderService) {
        this.orderService = orderService;
    }

    /**@PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        Order order = orderService.createOrder(order);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }**/
}
