package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.StoreMapRepository;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class StoreService {
    private final StoreMapRepository repository;
    private final UserMapRepository repositoryuser;

    public StoreService(final StoreMapRepository repository, UserMapRepository repositoryuser) {
        this.repository = repository;
        this.repositoryuser = repositoryuser;
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

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return null;
        //return repositoryuser.save(user);
    }
}