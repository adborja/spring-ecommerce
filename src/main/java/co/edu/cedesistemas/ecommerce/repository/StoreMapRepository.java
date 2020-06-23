package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreMapRepository implements StoreRepository {
    protected final Map<String, Store> repository;

    public StoreMapRepository(Map<String, Store> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends Store> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println("Saving to map");
        return entity;
    }

    @Override
    public Store findById(String id) {
        System.out.println("Finding from Map");
        return repository.get(id);
    }

    @Override
    public Iterable<Store> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    public List<Store> findByName(final String name) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }
}
