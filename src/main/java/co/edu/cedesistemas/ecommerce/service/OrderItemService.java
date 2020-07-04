package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository){
        this.repository = repository;
    }

    public List<OrderItem> findAllByOrder(String orderId) {
        return repository.findAllByOrder(orderId);
    }
}
