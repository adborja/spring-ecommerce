package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem created = itemService.createOrderItem(orderItem);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable String id) {
        OrderItem found = itemService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    /**@GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getOrderItemByOrder(@PathVariable String id) {
        List<OrderItem> orders = itemService.findAllByOrder(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }**/
}
