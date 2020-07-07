package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(final UserRepository repository){
        this.repository = repository;
    }

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    public User getById(final String id){
        return repository.findById(id).orElse(null);
    }

    public User getByEmail(final String email){
        return repository.findByEmail(email);
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
