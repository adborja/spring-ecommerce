package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderService orderService;


    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        Order found = orderService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
//        Order created = orderService.(order);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getOrderItems(@PathVariable String id) {
        Order foundAll = orderService.findById(id);
        return new ResponseEntity<>(foundAll.getItems(), HttpStatus.OK);
    }

}
