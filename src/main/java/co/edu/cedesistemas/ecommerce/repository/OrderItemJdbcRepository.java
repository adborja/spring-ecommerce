package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
//import co.edu.cedesistemas.ecommerce.service.ProductService;
//import org.springframework.context.ApplicationContext;
//import co.edu.cedesistemas.ecommerce.model.Product;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

//@Repository
//@Primary
public class OrderItemJdbcRepository implements OrderItemRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**@Override
    public List<OrderItem> findAllByOrder(String orderId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getJdbcTemplate())
                .withProcedureName("get_order_items")
                .returningResultSet("order_items", new OrderItemRowMapper());

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("oId", orderId);

        return (List<OrderItem>) jdbcCall.execute(in).get("order_items");
    }

    private static class OrderItemRowMapper implements RowMapper<OrderItem> {
        @Override
        public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderItem orderItem = new OrderItem();
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");
            ProductService productService = context.getBean("productService", ProductService.class);

            orderItem.setId(rs.getString("id"));
            orderItem.setOrderId(rs.getString("orderId"));
            orderItem.setProduct(productService.getById(rs.getString("productId")));
            //orderItem.setProduct(null);
            orderItem.setFinalPrice(rs.getFloat("finalPrice"));
            orderItem.setQuantity(rs.getInt("quantity"));
            return orderItem;
        }
    }**/

    public List<OrderItem> findAllByOrderMongo(String orderId) {
        final String query = "SELECT * FROM order_item WHERE orderId = :orderId";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("orderId", orderId);
        System.out.println("Finding By Id from database: " + orderId);
        return jdbcTemplate.queryForList (query, namedParameters, OrderItem.class);
    }

    public List<OrderItem> findAllByOrder(String orderId) {
        final String query = "SELECT * FROM order_item WHERE orderId = :orderId";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("orderId", orderId);
        System.out.println("Finding By Id from database: " + orderId);
        return jdbcTemplate.queryForList (query, namedParameters, OrderItem.class);
    }

    @Override
    public <S extends OrderItem> S save(S entity) {
        final String insertQ = "INSERT INTO order_item (id, orderId, productId, finalPrice, quantity)" +
                " VALUES (:id, :orderId, :productId, :finalPrice, :quantity)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("orderId", entity.getOrderId())
                .addValue("productId", entity.getProduct().getId())
                .addValue("finalPrice", entity.getFinalPrice())
                .addValue("quantity", entity.getQuantity());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated Order Item in database");
        return entity;
    }

    @Override
    public OrderItem findById(String id) {
        final String query = "SELECT * FROM order_item WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding By Id from database: " + id);
        return jdbcTemplate.queryForObject(query, namedParameters, OrderItem.class);
    }

    @Override
    public void remove(String id) {
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
}
