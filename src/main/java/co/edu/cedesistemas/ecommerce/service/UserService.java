package co.edu.cedesistemas.ecommerce.service;

//import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.model.document.User;
//import co.edu.cedesistemas.ecommerce.repository.UserRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(final UserRepository repository){
        this.repository= repository;
    }

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    public User getByID(final String id){
        return repository.findById(id).orElse(null);
    }

    public void delete(final String id){
        repository.deleteById(id);
    }

    public List<User> getByEmail(final String email){
        return repository.findByEmail(email);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser (String id, User user)
    {
        User userUpdate = getByID(id);
        userUpdate.setEmail(user.getEmail() != null ? user.getEmail() : userUpdate.getEmail());
        userUpdate.setName(user.getName() != null ? user.getName() : userUpdate.getName());
        userUpdate.setLastName(user.getLastName() != null ? user.getLastName() : userUpdate.getLastName());
        return repository.save(userUpdate);
    }
}
