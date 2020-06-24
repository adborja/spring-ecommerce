package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StoreMapRepository extends AbstractMapRepository<Store, String> {
    public StoreMapRepository(Map<String, Store> repository) {
        super(repository);
    }

    public Set<Store> findByName(final String name) {
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toSet());
    }
}
