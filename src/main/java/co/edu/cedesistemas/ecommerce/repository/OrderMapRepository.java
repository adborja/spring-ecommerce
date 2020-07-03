package co.edu.cedesistemas.ecommerce.repository;
import co.edu.cedesistemas.ecommerce.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class OrderMapRepository implements OrderRepository{

    protected final Map<String, Order> repository;

    public OrderMapRepository(Map<String, Order> repository) {
        this.repository = repository;
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
