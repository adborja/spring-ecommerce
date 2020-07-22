package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.repository.mongo.StoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
public class StoreService {
    private final StoreRepository repository;

    public StoreService(final StoreRepository repository) {
        this.repository = repository;
    }

    public Store createStore(Store store) {
        store.setId(UUID.randomUUID().toString());
        store.setCreatedAt(LocalDateTime.now());
        return repository.save(store);
    }

    public Store getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public Set<Store> getByName(final String name) {
        //return repository.findByName(name);
        return null;
    }

    public Iterable<Store> getAllStores() {
        return repository.findAll();
    }

    public Iterable<Store> getStoresByType(Store.Type type) {
        return null;
    }
}