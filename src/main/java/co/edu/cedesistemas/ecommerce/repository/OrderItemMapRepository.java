package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderItemMapRepository extends AbstractMapRepository<Store, String> {
    public OrderItemMapRepository(Map<String, Store> repository) {
        super(repository);
    }

    public Set<Store> findByName(final String name) {
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toSet());
    }
}
