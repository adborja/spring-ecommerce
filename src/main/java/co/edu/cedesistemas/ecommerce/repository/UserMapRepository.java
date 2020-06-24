package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Entity;

import java.util.Map;

public class UserMapRepository < T extends Entity<ID>, ID> extends AbstractMapRepository <T, ID> {
    public UserMapRepository(Map<ID, T> repository) {
        super(repository);
    }
}
