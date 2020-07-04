package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserRepository;
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
        return repository.findById(id);
    }

    //eliminar un usuario dado su ID
    public void deleteUser(final String id) {
        repository.remove(id);
    }

    // obtener un usuario dado su email
    public Set<User> getByEmail(final String email) {
        return repository.findByEmail(email);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

}
