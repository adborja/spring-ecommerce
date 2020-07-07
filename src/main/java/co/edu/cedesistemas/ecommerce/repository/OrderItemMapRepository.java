package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;

import java.util.Map;

public class OrderItemMapRepository implements OrderItemRepository {

    protected final Map<String, OrderItem> repository;

    public OrderItemMapRepository(Map<String, OrderItem> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends OrderItem> S save(S entity) {
        return null;
    }

    @Override
    public OrderItem findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<OrderItem> findAll() {
        return null;
    }

}
