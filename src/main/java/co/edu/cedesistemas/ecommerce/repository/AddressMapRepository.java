package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressMapRepository extends AbstractMapRepository<Address, String> {
    public AddressMapRepository(Map<String, Address> repository) {
        super(repository);
    }

    public Set<Address> findByName(final String name) {
        return repository.values().stream()
                .filter(p -> p.getName().contains(name))
                .collect(Collectors.toSet());
    }
}