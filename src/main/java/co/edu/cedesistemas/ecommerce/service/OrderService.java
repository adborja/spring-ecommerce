package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.StoreRepository;
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

    public Order createOrder(Order o) {
        o.setId(UUID.randomUUID().toString());
        o.setCreatedAt(LocalDateTime.now());
        return repository.save(o);
    }

    public Order getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public Iterable<Order> getAllStores() {
        return repository.findAll();
    }

}