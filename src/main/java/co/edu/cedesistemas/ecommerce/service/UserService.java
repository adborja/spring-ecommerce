package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(final UserRepository repository){
        this.repository = repository;
    }

    //Crear usuario
    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    //Buscar usuario por ID
    public User getById(final String id){
        return repository.findById(id).orElse(null);
    }

    //Eliminar usurio por ID
/*    public void delete(final String id){
        repository.remove(id);
    }*/

    //Buscar usuario por email
    /*public Set<User> getByEmail(final String email){
        return repository.findByEmail(email);
    }*/
    public User getByEmail(final String email) {
        return repository.findByEmail(email);
    }

    //Buscar todos los usuarios
    public Iterable<User> getAllUsers(){
        return repository.findAll();
    }

    public User updateUser(String id, User user) {
        User foundUser = getById(id);
        foundUser.setEmail(user.getEmail() != null ? user.getEmail() : foundUser.getEmail());
        foundUser.setName(user.getName() != null ? user.getName() : foundUser.getName());
        foundUser.setLastName(user.getLastName() != null ? user.getLastName() : foundUser.getLastName());
        return repository.save(foundUser);
    }
}
