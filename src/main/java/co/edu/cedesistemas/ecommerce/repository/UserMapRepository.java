package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapRepository extends AbstractMapRepository<User, String> {

    public UserMapRepository(Map<String, User> repository) {
        super(repository);
    }

    public Set<User> findByEmail(final String email){
        return repository.values().stream()
                .filter(s -> s.getEmail().contains(email))
                .collect(Collectors.toSet());
    }
}
