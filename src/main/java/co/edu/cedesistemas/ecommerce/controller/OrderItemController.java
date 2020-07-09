package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.service.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController (final OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem created = orderItemService.createOrderItem(orderItem);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable String id) {
        OrderItem found = orderItemService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getOrderItemByOrder(@PathVariable String orderId) {
        List<OrderItem> orders = orderItemService.findAllByOrder(orderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
