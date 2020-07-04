package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderMapRepository extends AbstractMapRepository<Order, String> {
    public OrderMapRepository(Map<String, Order> repository) {
        super(repository);
    }

    public Set<Order> findByName(final String name) {
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toSet());
    }
}
