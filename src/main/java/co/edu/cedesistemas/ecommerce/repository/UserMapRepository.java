package co.edu.cedesistemas.ecommerce.repository;


import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;
import java.util.Map;


public class UserMapRepository implements UserRepository {
    protected final Map<String, User> repository;
    public UserMapRepository(Map<String, User> repository) {
        this.repository = repository;
    }

    public List<User> findByEmail(String email) {
        System.out.println("Finding from email");
        return (List<User>) repository.get(email);
    }


    @Override
    public <S extends User> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println("Saving to map");
        return entity;
    }

    @Override
    public User findById(String id) {
        System.out.println("Finding from Map");
        return repository.get(id);
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    @Override
    public Iterable<User> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }
}
