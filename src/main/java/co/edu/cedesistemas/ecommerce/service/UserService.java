package co.edu.cedesistemas.ecommerce.service;


import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    //Crear usuario
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    //obtener un usuario dado su ID
    public User getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    // obtener un usuario dado su email
    public Set<User> getByEmail(final String email) {
        return repository.findByEmail(email);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(String id, User user) {
        User found = getById(id);
        found.setEmail(user.getEmail() != null ? user.getEmail() : found.getEmail());
        found.setName(user.getName() != null ? user.getName() : found.getName());
        found.setLastName(user.getLastName() != null ? user.getLastName() : found.getLastName());

        return repository.save(found);
    }


}
