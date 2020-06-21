package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;

import java.util.Map;

public class UserMapRepository extends AbstractMapRepository<User, String> {

    public UserMapRepository(Map<String, User> repository) {
        super(repository);
    }
}
