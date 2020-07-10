package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.document.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Repository
public class UserMapRepository implements UserRepository {

    protected final Map<String, User> repository;
    public UserMapRepository(Map<String, User> repository) {
        this.repository = repository;
    }

    public List<User> findByEmail(final String email){
        return (List<User>) repository.values().stream().filter(s -> s.getEmail().contains(email))
                .collect(Collectors.toSet());
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
