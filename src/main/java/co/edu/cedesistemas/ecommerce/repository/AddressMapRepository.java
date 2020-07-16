package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import co.edu.cedesistemas.ecommerce.model.Address;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//@Repository
public class AddressMapRepository implements AddressRepository {
    protected final Map<String, Address> repository;

    public AddressMapRepository(Map<String, Address> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends Address> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println("Saving to map");
        return entity;
    }

    @Override
    public Address findById(String id) {
        System.out.println("Finding from Map");
        return repository.get(id);
    }

    @Override
    public Iterable<Address> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    public List<Address> findByName(final String name) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

}

