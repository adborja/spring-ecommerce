package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class OrderJdbcRepository implements OrderRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Order> S save(final S entity) {
        final String insertQ = "INSERT INTO order (id, user, store, shippingAddress)" +
                " VALUES (:id, :user, :store, :shippingAddress)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("user", entity.getUser())
                .addValue("store", entity.getStore())
                .addValue("shippingAddress", entity.getShippingAddress());
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
    public List<Order> findByUserName(final String name) {
        final String query = "SELECT * FROM order WHERE name LIKE :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, Order.class);
    }


}
