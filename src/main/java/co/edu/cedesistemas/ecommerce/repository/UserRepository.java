package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;

public interface UserRepository extends Repository<User, String> {
    List<User> findByName(String name);
}