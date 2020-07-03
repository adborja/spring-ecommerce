package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderMapRepository implements OrderRepository {
    protected final Map<String, Order> repository;

    public OrderMapRepository(Map<String, Order> repository) {
        this.repository = repository;
    }

    public List<Order> findByStore(final String name) {
        return repository.values().stream()
                .filter(s -> s.getStore().equals(name))
                .collect(Collectors.toList());
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
