package co.edu.cedesistemas.ecommerce.repository;


import co.edu.cedesistemas.ecommerce.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderMapRepository implements OrderRepository {

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
