package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapRepository implements UserRepository{

    protected final Map<String, User> repository;

    public UserMapRepository(Map<String, User> repository){
        this.repository = repository;
    }

    public Set<User> findByEmail(final String email){
        return repository.values().stream()
                .filter(s -> s.getEmail().contains(email))
                .collect(Collectors.toSet());
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
}
