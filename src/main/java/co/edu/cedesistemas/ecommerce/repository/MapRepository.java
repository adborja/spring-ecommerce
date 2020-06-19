package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Entity;

public interface MapRepository<T extends Entity<ID>, ID> extends Repository<T, ID> {

}