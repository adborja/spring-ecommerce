package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderItemJdbcRepository implements OrderItemRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

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
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getJdbcTemplate())
                .withProcedureName("get_order_items")
                .returningResultSet("order_items", new OrderItemRowMapper());

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("oId,", orderId);
        return (List<OrderItem>) jdbcCall.execute(in).get("order_items");
    }

    private static class OrderItemRowMapper implements RowMapper<OrderItem> {
        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(rs.getString("id"));
            orderItem.setOrderId(rs.getString("orderId"));
            //orderItem.setProduct(rs.getString("productId"));
            orderItem.setFinalPrice(rs.getFloat("finalPrice"));
            orderItem.setQuantity(rs.getInt("quantity"));
            return orderItem;

        }
    }

}
