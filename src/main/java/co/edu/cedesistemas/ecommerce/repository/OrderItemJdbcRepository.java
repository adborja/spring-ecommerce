package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.model.Store;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class OrderItemJdbcRepository implements OrderItemRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
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
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate.getJdbcTemplate())
                .withProcedureName("get_order_items")
          //      .returningResultSet("order_item",new OrderItemRowMapper(jdbcTemplate));
                .returningResultSet("order_item",new OrderItemRowMapper());

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("oId",orderId);
        return (List<OrderItem>) simpleJdbcCall.execute(sqlParameterSource).get("order_item");
    }

    private static class OrderItemRowMapper implements RowMapper<OrderItem> {
        /*private final NamedParameterJdbcTemplate jdbcTemplate;

        public OrderItemRowMapper(NamedParameterJdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }*/

        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {

            OrderItem orderItem = new OrderItem();
            orderItem.setId(rs.getString("id"));
            orderItem.setOrderId(rs.getString("orderId"));
            orderItem.setFinalPrice(rs.getFloat("finalPrice"));
            orderItem.setQuantity(rs.getInt("quantity"));
            //ProductJdbcRepository productJdbcRepository = new ProductJdbcRepository(this.jdbcTemplate);
            Product product = new Product();
            product.setId(rs.getString("productId"));
            orderItem.setProduct(product);

            return orderItem;
        }
    }
}
