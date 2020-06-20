package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;

import java.util.Set;
import java.util.UUID;

public class UserService {
    private final UserMapRepository repository;

    public UserService(final UserMapRepository repository){
        this.repository = repository;
    }

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    public User getById(final String id){
        return repository.findById(id);
    }

    public void delete(final String id){
        repository.remove(id);
    }

    public Set<User> getByEmail(final String email){
        return repository.findByEmail(email);
    }

    public Iterable<User> getAllUser(){
        return repository.findAll();
    }

}
