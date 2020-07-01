package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapRepository implements UserRepository {
    protected final Map<String, User> repository;

    public UserMapRepository(Map<String, User> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByName(final String name) {
        return (List<User>) repository.values().stream()
                .filter(p -> p.getName().contains(name))
                .collect(Collectors.toSet());
    }
}