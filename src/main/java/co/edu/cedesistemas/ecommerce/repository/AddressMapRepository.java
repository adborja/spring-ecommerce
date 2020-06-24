package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;

public class AddressMapRepository extends AbstractMapRepository<Store,String>{

    public AddressMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
