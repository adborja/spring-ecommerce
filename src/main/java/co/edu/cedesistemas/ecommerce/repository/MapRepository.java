package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.AbstractEntity;

public interface MapRepository<T extends AbstractEntity<ID>, ID> extends Repository<T, ID> {

}