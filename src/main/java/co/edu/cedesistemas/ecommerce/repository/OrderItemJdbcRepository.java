package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class OrderItemJdbcRepository implements OrderItemRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends OrderItem> S save(S entity) {
        final String insertQ = "INSERT INTO store (id, orderId, product, finalPrice, quantity)" +
                " VALUES (:id, :orderId, :product, :finalPrice, :quantity)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("orderId", entity.getOrderId())
                .addValue("product", entity.getProduct())
                .addValue("finalPrice", entity.getFinalPrice())
                .addValue("quantity", entity.getQuantity());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
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
            orderItem.setFinalPrice(rs.getFloat("finalPrice"));
            orderItem.setQuantity(rs.getInt("quantity"));
            Product product = new Product();
            product.setId(rs.getString("productId"));
            orderItem.setProduct(product);
            return orderItem;

        }
    }

}
