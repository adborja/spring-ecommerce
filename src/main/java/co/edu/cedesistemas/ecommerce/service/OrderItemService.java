package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.repository.OrderItemRepository;

import java.util.List;

public class OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository){
        this.repository = repository;
    }

    public List<OrderItem> findAllByOrder(String orderId) {
        return repository.findAllByOrder("1");
    }
}
