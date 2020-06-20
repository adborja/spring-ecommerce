package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.repository.AbstractMapRepository;

import java.util.Map;

public class OrderMapRepository extends AbstractMapRepository<Store, String> {
    public OrderMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
