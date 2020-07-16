package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
//@Repository
//@Primary
public class OrderJdbcRepository implements OrderRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Order> S save(final S entity) {
        final String insertQ = "INSERT INTO order (id, userId, storeId, shippingAddressId)" +
                " VALUES (:id, :userId, :storeId, :shippingAddressId)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("userId", entity.getUser())
                .addValue("storeId", entity.getStore())
                .addValue("shippingAddressId", entity.getShippingAddress());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
    }

    @Override
    public Order findById(final String id) {
        final String query = "SELECT * FROM order WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, Order.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM order WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<Order> findAll() {
        final String query = "SELECT * FROM order";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Order.class));
    }

    @Override
    public List<Order> findByUser(final String user) {
        final String query = "SELECT * FROM order WHERE userId LIKE :user";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("user", user);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, Order.class);
    }

}
