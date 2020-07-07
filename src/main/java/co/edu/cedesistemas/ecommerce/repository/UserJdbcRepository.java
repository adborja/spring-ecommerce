package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//@Primary
public class UserJdbcRepository implements UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findByEmail(String email) {
        return null;
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
}
