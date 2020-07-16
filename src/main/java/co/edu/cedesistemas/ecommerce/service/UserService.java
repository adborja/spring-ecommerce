package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.StoreMapRepository;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        //acá no sé que otro campo debo pasar ya que el repositorio es de tipo usermap y espera dos valores el ID y un User
        return repository.save(user);
    }

    public User getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> getByMail(final String email) {
        return repository.findByEmail(email);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser (String id, User user) {
        User found = getById(id);
        found.setEmail(user.getEmail() != null ? user.getEmail() : found.getEmail());
        found.setLastName(user.getLastName() != null ? user.getName() : found.getLastName());
        found.setName(user.getName() != null ? user.getName() : found.getName());
        return  repository.save(found);
    }
}