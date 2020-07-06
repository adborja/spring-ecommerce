package co.edu.cedesistemas.ecommerce.service;

<<<<<<< HEAD
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.repository.StoreRepository;
=======
import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.repository.mongo.StoreRepository;
>>>>>>> base
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    public List<Store> getByName(final String name) {
        return repository.findByNameLike(name);
    }

    public Iterable<Store> getAllStores() {
        return repository.findAll();
    }

    public Iterable<Store> getStoresByType(Store.Type type) {
        return repository.findByType(type);
    }
}