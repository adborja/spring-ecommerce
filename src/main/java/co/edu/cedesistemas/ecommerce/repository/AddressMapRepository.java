package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressMapRepository implements AddressRepository {
    protected final Map<String, Address> repository;

    public AddressMapRepository(Map<String, Address> repository) {
        this.repository = repository;
    }

    public List<Address> findByName(final String name) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public <S extends Address> S save(S entity) {
        return null;
    }

    @Override
    public Address findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<Address> findAll() {
        return null;
    }
}
