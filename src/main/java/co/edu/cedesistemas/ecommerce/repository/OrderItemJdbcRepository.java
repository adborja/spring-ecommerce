package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
//@Repository
public class  OrderItemJdbcRepository implements OrderItemRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private ProductJdbcRepository productJdbcRepository;

    public OrderItemJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate,
                                   ProductJdbcRepository productJdbcRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.productJdbcRepository = productJdbcRepository;
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
