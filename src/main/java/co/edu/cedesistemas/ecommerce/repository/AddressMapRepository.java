package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressMapRepository implements AddressRepository {

    protected final Map<String, Address> repository;

    public AddressMapRepository(Map<String, Address> repository) {
        this.repository = repository;
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
