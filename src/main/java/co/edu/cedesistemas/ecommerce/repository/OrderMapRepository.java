package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderMapRepository extends AbstractMapRepository<Order, String> {
    public OrderMapRepository(Map<String, Order> repository) {
        super(repository);
    }

    public Set<Order> findByUser(final User user) {
        return repository.values().stream()
                .filter(u -> u.getUser(user))
                .collect(Collectors.toSet());
    }
}