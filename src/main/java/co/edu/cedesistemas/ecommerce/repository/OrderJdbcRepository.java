package co.edu.cedesistemas.ecommerce.repository;
import org.springframework.stereotype.Repository;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

//@Repository
public class OrderJdbcRepository implements OrderRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Order> S save(S entity) {
        return null;
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
