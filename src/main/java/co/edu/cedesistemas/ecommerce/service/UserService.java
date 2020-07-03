package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    public User getById(final String id) {
        return repository.findById(id);
    }

    public void delete(final String id) {
        repository.remove(id);
    }

    public List<User> getByEmail(final String email) {
        return repository.findByEmail(email);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }
}


