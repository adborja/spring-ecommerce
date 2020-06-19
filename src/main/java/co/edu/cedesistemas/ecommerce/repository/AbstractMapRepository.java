package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.AbstractEntity;

import java.util.Map;

public abstract class AbstractMapRepository<T extends AbstractEntity<ID>, ID> implements MapRepository<T, ID> {
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
