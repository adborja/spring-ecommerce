package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;

public class OrderMapRepository extends AbstractMapRepository<Store,String>{
    public OrderMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
