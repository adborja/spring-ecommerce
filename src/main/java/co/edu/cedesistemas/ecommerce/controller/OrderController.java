package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService oService;

    public OrderController(final OrderService oService) {
        this.oService = oService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Order o) {
        Order created = oService.createOrder(o);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        Order found = oService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getItemsByOrder(@PathVariable String id) {
        List<OrderItem> items = oService.getById(id).getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        Iterable<Order> o = oService.getAllOrders();

        if (o == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
