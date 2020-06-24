package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderItemMapRepository extends AbstractMapRepository<OrderItem, String> {
    public OrderItemMapRepository(Map<String, OrderItem> repository) {
        super(repository);
    }

    public Set<OrderItem> findByOrder(final String orderId) {
        return repository.values().stream()
                .filter(oi -> oi.getOrderId())
                .collect(Collectors.toSet());
    }
}