package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Set;

//@Repository
public class UserJdbcRepository implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public <S extends User> S save(S entity) {
        final String insertQ = "INSERT INTO store (id, name, lastName, email)" +
                " VALUES (:id, :name, :lastName, :email)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("lastName", entity.getLastName())
                .addValue("email", entity.getEmail());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
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
    public Set<User> findByEmail(String email) {
        return null;
    }
}
