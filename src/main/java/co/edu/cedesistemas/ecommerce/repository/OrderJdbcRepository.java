package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

//@Repository
public class OrderJdbcRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Order> S save(S entity) {

        final String insertQ = "INSERT INTO store (id, user, store, shippingAddress)" +
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
    public Order findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }
}
