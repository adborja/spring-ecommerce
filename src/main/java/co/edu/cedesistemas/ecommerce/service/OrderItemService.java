package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
//import co.edu.cedesistemas.ecommerce.repository.OrderItemRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemService(final OrderItemRepository repository){
        this.repository = repository;
    }

    public OrderItem createOrderItem(OrderItem orderItem){
        orderItem.setId(UUID.randomUUID().toString());
        return repository.save(orderItem);
    }

    public OrderItem getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public List<OrderItem> findAllByOrder(String orderId) {
        return repository.findAllByOrder(orderId);
    }
}
