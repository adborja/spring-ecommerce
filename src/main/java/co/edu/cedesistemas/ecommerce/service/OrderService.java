package co.edu.cedesistemas.ecommerce.service;


import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setStatus(Order.Status.CREATED);
        return repository.save(order);
    }
    public Order getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public List<OrderItem> getItemsByIdOrder(String id){
        return getById(id).getItems();
    }

 }
