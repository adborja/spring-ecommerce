package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface UserRepository extends Repository<User, String> {
    Set<User> findByEmail(String name);
}
