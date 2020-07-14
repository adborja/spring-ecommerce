package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
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

    public  User getByEmail(final String email){
        return (User) repository.findByEmail(email);
    }

    public Iterable<User> getAllUser(){
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
