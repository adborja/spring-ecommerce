package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//@Repository
public class OrderItemMapRepository implements OrderItemRepository {
    protected final Map<String, OrderItem> repository;

    public OrderItemMapRepository(Map<String, OrderItem> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends OrderItem> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println("Saving to map");
        return entity;
    }

    @Override
    public OrderItem findById(String id) {
        System.out.println("Finding from Map");
        return repository.get(id);
    }

    @Override
    public Iterable<OrderItem> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    @Override
    public List<OrderItem> findAllByOrder(String orderId) {
            return repository.values().stream()
                    .filter(s -> s.getOrderId().equals(orderId))
                    .collect(Collectors.toList());
        }
}

