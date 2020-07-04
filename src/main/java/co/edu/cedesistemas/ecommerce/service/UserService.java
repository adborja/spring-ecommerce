package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.StoreMapRepository;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class UserService {
    private final UserMapRepository repository;

    public UserService(final UserMapRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        //acá no sé que otro campo debo pasar ya que el repositorio es de tipo usermap y espera dos valores el ID y un User
        user.setName(name);
        return repository.save(store);
    }

    public User getById(final String id) {
        return repository.findById(id);
    }

    public void delete(final String id) {
        repository.remove(id);
    }

    public Set<User> getByMail(final String mail) {
        return repository.findByMail(mail);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }
}