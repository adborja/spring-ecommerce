package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Set;

public class UserJdbcRepository implements UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Set<User> findByEmail(String name) {
        return null;
    }
}
