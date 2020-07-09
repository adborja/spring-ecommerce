package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public User updateUser(User user, String id) {
        User original = getById(id);
        original.setEmail(user.getEmail() != null ? user.getEmail() : original.getEmail());
        original.setName(user.getName() != null ? user.getName() : original.getName());
        original.setLastName(user.getLastName() != null ? user.getLastName() : original.getLastName());
        return repository.save(original) ;
    }


}



