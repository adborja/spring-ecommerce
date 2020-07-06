package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.OrderItem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderItemMapRepository implements OrderItemRepository{

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
        return repository.get(s);
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<OrderItem> findAll() {
        return null;
    }


    @Override
    public List<OrderItem> findAllByOrder(String orderId) {
        return repository.values().stream().filter(s -> s.getOrderId().equals(orderId))
                .collect(Collectors.toList());
    }

}
