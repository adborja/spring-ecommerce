package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapRepository extends AbstractMapRepository<User, String> {
    public UserMapRepository(Map<String, User> repository) {
        super(repository);
    }

    public Set<User> findByName(final String name) {
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toSet());
    }

    //creación del metodo para encontrar por el usuario por el mail
    public Set<User> findByMail(final String email) {
        return repository.values().stream()
                .filter(s -> s.getEmail().contains(email))
                .collect(Collectors.toSet());
    }
}
