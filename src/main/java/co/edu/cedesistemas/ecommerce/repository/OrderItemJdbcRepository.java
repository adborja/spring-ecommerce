package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.model.Store;
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
public class OrderItemJdbcRepository implements OrderItemRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends OrderItem> S save(final S entity) {
        final String insertQ = "INSERT INTO order_item (id, orderId, productId, finalPrice, quantity)" +
                " VALUES (:id, :orderId, :productId, :finalPrice, :quantity)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("orderId", entity.getOrderId())
                .addValue("productId", entity.getProduct())
                .addValue("finalPrice", entity.getFinalPrice())
                .addValue("quantity", entity.getQuantity());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
    }

    @Override
    public OrderItem findById(final String id) {
        final String query = "SELECT * FROM order_item WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, OrderItem.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM order_item WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<OrderItem> findAll() {
        final String query = "SELECT * FROM order_item";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(OrderItem.class));
    }
    @Override
    public List<OrderItem> findAllByOrder(String id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getJdbcTemplate())
                .withProcedureName("get_order_items")
                .returningResultSet("order", new OrderItemJdbcRepository.OrderItemRowMapper());

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("order", id);

        return (List<OrderItem>) jdbcCall.execute(in).get("order");
    }

    private static class OrderItemRowMapper implements RowMapper<OrderItem> {
        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderItem order = new OrderItem();
            order.setId(rs.getString("id"));
            order.setOrderId(rs.getString("orderId"));
            order.setProduct(rs.getString("productId"));
            order.setFinalPrice(rs.getFloat("finalPrice"));
            order.setQuantity(rs.getInt("quantity"));
            return order;
        }
    }

}
