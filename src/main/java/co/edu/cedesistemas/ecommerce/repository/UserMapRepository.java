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
    public Iterable<User> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    public List<User> findByName(final String name) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

    //creación del metodo para encontrar por el usuario por el mail
    public List<User> findByMail(final String email) {
        return repository.values().stream()
                .filter(s -> s.getEmail().contains(email))
                .collect(Collectors.toList());
    }
}
