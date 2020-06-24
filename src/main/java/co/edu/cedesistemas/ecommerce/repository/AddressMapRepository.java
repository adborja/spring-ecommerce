package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressMapRepository extends AbstractMapRepository<Address, String> {
    public AddressMapRepository(Map<String, Address> repository) {
        super(repository);
    }

    public Set<Adress> findByName(final String name) {
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toSet());
    }
}
