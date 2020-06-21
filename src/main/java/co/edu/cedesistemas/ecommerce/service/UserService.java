package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;

import java.util.UUID;

public class UserService {

    private final UserMapRepository repository;

    public UserService(final UserMapRepository repository){
        this.repository = repository;
    }

    //Crear usuario
    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }

    //Buscar usuario por ID
    public User getById(final String id){
        return repository.findById(id);
    }

    //Eliminar usurio por ID
    public void delete(final String id){
        repository.remove(id);
    }

    //Buscar usuario por email
    public User getByEmail(final String email){
        return repository.findById(email);
    }

}
