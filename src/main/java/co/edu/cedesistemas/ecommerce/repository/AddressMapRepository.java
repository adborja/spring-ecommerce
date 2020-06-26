package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressMapRepository extends AbstractMapRepository<Store, String> {

    public AddressMapRepository(Map<String, Store> repository) {

        super(repository);
    }


}
