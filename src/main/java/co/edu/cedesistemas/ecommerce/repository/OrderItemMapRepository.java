package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderItemMapRepository implements OrderItemRepository {
    protected final Map<String, OrderItem> repository;

    public OrderItemMapRepository(Map<String, OrderItem> repository)
    {
        this.repository= repository;
    }

    public List<OrderItem> findAllByOrderLike(final String orderId) {
        return repository.values().stream()
                .filter(s -> s.getOrderId().equals(orderId))
                .collect(Collectors.toList());
    }

    public List<OrderItem> findAllByOrder(final String orderId) {
        return repository.values().stream()
                .filter(s -> s.getOrderId().equals(orderId))
                .collect(Collectors.toList());
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
