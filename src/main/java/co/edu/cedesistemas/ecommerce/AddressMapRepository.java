package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.repository.AbstractMapRepository;

import java.util.Map;

public class AddressMapRepository extends AbstractMapRepository<Store, String> {
    public AddressMapRepository(Map<String, Store> repository) {
        super(repository);
    }
}
