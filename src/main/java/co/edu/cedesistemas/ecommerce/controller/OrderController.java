package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getStoreById(@PathVariable String id) {
        List<OrderItem> found = orderService.getItemsByIdOrder(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

}
