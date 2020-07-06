package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class UserJdbcRepository implements UserRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends User> S save(S entity) {
        final String insertQ = "INSERT INTO user (id, name, lastName, email)" +
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
    public User findById(final String id) {
        final String query = "SELECT * FROM user WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, User.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM user WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<User> findAll() {
        final String query = "SELECT * FROM user";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findByEmail(final String email) {
        final String query = "SELECT id FROM user WHERE email = :email LIMIT 1";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, User.class);
    }
}

