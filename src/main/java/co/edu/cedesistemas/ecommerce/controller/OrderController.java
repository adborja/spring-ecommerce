package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
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
public class OrderController {
    private OrderItemService orderItemService;

    public OrderController (final OrderItemService orderItemService) {
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

    //Tiene comentarios porque genera error cuando se ejecuta el test.
    //No puede resolver OrderItem y sale error.
    /**@GetMapping("/orders/{id}/items")
    public ResponseEntity<?> getOrderItemByOrder(@PathVariable String id) {
        List<OrderItem> orders = orderItemService.findAllByOrder(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }**/

}
