package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;

public interface Repository<T, ID> {
    <S extends T> S save(S entity);
    T findById(ID id);
    void remove(ID id);
    Iterable<T> findAll();

}
