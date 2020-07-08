package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.document.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface UserRepository extends Repository<User, String> {
    List<User> findByEmail(String name);
}
