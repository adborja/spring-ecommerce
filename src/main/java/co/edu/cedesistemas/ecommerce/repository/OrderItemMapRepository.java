package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;

public class OrderItemMapRepository extends AbstractMapRepository<Store,String>{
    public OrderItemMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
