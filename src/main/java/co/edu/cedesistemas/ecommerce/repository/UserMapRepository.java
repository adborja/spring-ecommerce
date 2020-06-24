package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;

public class UserMapRepository extends AbstractMapRepository<Store,String>{
    public UserMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
