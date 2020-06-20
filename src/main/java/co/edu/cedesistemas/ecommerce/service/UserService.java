package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.UserMapRepository;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.UUID;

public class UserService extends User {//TODO Está bien extender de User sin usar la interfaz?
    private final UserMapRepository repository;

    public UserService(final UserMapRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setEmail("dummy@summy.com");
        return repository.save(user);
    }

    public User getById(final String id) {
        return repository.findById(id);
    }

    public void delete(final String id) {
        repository.remove(id);
    }

    @Override//TODO Está bien extender de User sin usar la interfaz?
    public String getEmail() {
        return super.getEmail();
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }
}


