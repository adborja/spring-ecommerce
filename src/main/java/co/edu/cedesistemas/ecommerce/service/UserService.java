package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.UserMapRepository;

public class UserService {
    private final UserMapRepository repository;

    public UserService( final UserMapRepository repository) {
        this.repository = repository;
    }

    public User createUser (User user){
        user.getId();
        user.getEmail();
        return (User) repository.save(user);
    }

    public User getById(final String id){
        return (User) repository.findById(id);
    }

    public void deleteUser(final String id) {
        repository.remove(id);
    }

    public UserMapRepository getByEmail(final String email) {
        return repository;
    }
}
