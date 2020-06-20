package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class UserServiceMapRepository extends AbstractMapRepository<User, String> {
    public UserServiceMapRepository(Map<String, User> repository) {
        super(repository);
    }

    public Set<User> findByName(final String name) {
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toSet());
    }

}
