package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.List;

public class  OrderItemJdbcRepository implements OrderItemRepository{
    @Override
    public <S extends OrderItem> S save(S entity) {
        return null;
    }

    @Override
    public OrderItem findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<OrderItem> findAll() {
        return null;
    }

    @Override
    public List<OrderItem> findAllByOrder(String orderId) {
        return null;
    }

    /*@Override
    public List<OrderItem> findAllByOrder(final String orderId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getJdbcTemplate())
                .withProcedureName("get_order_items")
                //.returningResultSet("orderItems", new Orde);
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("oId", orderId);

        return (List<OrderItem>) jdbcCall.execute(in).get("orderItems");
    }*/



}
