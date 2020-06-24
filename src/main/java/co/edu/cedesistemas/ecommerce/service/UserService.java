package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class StoreService {
    private final UserMapRepository repository;

    public UserService(final UserMapRepository repository) {
        this.repository = repository;
    }

    public Store createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    public User getById(final String id) {
        return repository.findById(id);
    }

    public void delete(final String id) {
        repository.remove(id);
    }

    public Set<User> getByName(final String name) {
        return repository.findByName(name);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }
}