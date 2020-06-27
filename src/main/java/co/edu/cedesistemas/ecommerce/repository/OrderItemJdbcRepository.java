package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderItemJdbcRepository implements OrderItemRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends OrderItem> S save(final S entity) {
        final String insertQ = "INSERT INTO orderItem (id, orderId, product, finalPrice, quantity)" +
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
    public OrderItem findById(final String id) {
        final String query = "SELECT * FROM orderItem WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, OrderItem.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM orderItem WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<OrderItem> findAll() {
        final String query = "SELECT * FROM orderItem";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(OrderItem.class));
    }

    @Override
    public List<OrderItem> findAllByOrder(final String orderId) {
        final String query = "SELECT * FROM order_item WHERE name LIKE :orderId";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("orderId", orderId);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, OrderItem.class);
    }


    private class OrderItemRowMapper implements RowMapper<OrderItem> {
        ProductjdbcRepository productjdbcRepository;
        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(rs.getString("id"));
            orderItem.setOrderId(rs.getString("orderId"));
//            orderItem.setProduct((rs.getString("productId")));
            orderItem.setProduct(productjdbcRepository.findById(rs.getString("productId")));
            orderItem.setFinalPrice(rs.getFloat("finalPrice"));
            orderItem.setQuantity(rs.getInt("quantity"));
            return orderItem;
        }
    }


//    private  Product findProduct(final String productId) {
//        final String query = "SELECT * FROM product WHERE id = :productId";
//        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("productId", productId);
//        System.out.println("Finding from database");
//        return jdbcTemplate.queryForObject(query, namedParameters, Product.class);
//    }
//
}
