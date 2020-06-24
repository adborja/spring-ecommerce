package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;

public class ProductMapRepository extends AbstractMapRepository<Store,String>{

    public ProductMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
