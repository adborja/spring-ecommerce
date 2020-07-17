package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(final OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order Order) {
        Order.setId(UUID.randomUUID().toString());
        Order.setCreatedAt(LocalDateTime.now());
        return repository.save(Order);
    }

    public Order getById(final String id) {
        return repository.findById(id).orElse(null);
    }


    public void delete(final String id) {
        repository.deleteById(id);
    }

    public Iterable<Order> getAllOrders() {
        return repository.findAll();
    }

}