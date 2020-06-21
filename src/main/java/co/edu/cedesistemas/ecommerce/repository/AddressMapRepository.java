package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;

import java.util.Map;

public class AddressMapRepository extends AbstractMapRepository<Address, String> {

    public AddressMapRepository(Map<String, Address> repository) {
        super(repository);
    }
}

