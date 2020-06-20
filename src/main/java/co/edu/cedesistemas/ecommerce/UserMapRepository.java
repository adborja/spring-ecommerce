package co.edu.cedesistemas.ecommerce;

import co.edu.cedesistemas.ecommerce.model.User;
import co.edu.cedesistemas.ecommerce.repository.AbstractMapRepository;

import java.util.Map;

public class UserMapRepository extends AbstractMapRepository<User, String> {
    public UserMapRepository(Map<String, User> repository) {
        super(repository);
    }
}
