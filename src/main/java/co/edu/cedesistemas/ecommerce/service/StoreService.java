package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.repository.StoreMapRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class StoreService {
    private final StoreMapRepository repository;

    public StoreService(final StoreMapRepository repository) {
        this.repository = repository;
    }

    public Store createStore(Store store) {
        store.setId(UUID.randomUUID().toString());
        store.setCreatedAt(LocalDateTime.now());
        return repository.save(store);
    }

    public Store getById(final String id) {
        return repository.findById(id);
    }

    public void delete(final String id) {
        repository.remove(id);
    }

    public Set<Store> getByName(final String name) {
        return repository.findByName(name);
    }

    public Iterable<Store> getAllStores() {
        return repository.findAll();
    }
}