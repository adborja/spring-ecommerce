package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Entity;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;
import java.util.Set;

public abstract class AbstractMapRepository<T extends Entity<ID>, ID> implements MapRepository<T, ID> {
    protected final Map<ID, T> repository;

    public AbstractMapRepository(Map<ID, T> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends T> S save(S entity) {
        repository.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public T findById(ID id) {
        return repository.get(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.values();
    }

    @Override
    public void remove(ID id) {
        repository.remove(id);
    }


}
