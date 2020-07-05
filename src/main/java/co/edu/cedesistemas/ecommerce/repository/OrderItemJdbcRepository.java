package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import co.edu.cedesistemas.ecommerce.model.OrderItem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
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
                .returningResultSet("order_item",new OrderItemRowMapper(jdbcTemplate));
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("oId",orderId);
        return (List<OrderItem>) simpleJdbcCall.execute(sqlParameterSource).get("order_item");
    }

    private static class OrderItemRowMapper implements RowMapper<OrderItem> {
        private final NamedParameterJdbcTemplate jdbcTemplate;

        public OrderItemRowMapper(NamedParameterJdbcTemplate jdbcTemplate) {

            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {

            OrderItem orderItem = new OrderItem();
            orderItem.setId(rs.getString("id"));
            orderItem.setOrderId(rs.getString("orderId"));
            orderItem.setFinalPrice(rs.getFloat("finalPrice"));
            orderItem.setQuantity(rs.getInt("quantity"));
            ProductJdbcRepository productJdbcRepository = new ProductJdbcRepository(this.jdbcTemplate);
            orderItem.setProduct(productJdbcRepository.findById(rs.getString("productId")));

            return orderItem;
        }
    }
}
