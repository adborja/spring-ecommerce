package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Entity;

import java.util.Map;

public class AddressMapRepository <T extends Entity<ID>, ID> extends AbstractMapRepository <T, ID> {

    public AddressMapRepository(Map<ID, T> repository) {
        super(repository);
    }
}
