package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Entity;

import java.util.Map;

public class OrderMapRepository <T extends Entity<ID>, ID> extends AbstractMapRepository <T, ID> {
    public OrderMapRepository(Map<ID, T> repository) {
        super(repository);
    }
}
