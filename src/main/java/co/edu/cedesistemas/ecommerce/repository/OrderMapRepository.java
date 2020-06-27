package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMapRepository implements OrderRepository {
    protected final Map<String, Order> repository;

    public OrderMapRepository(Map<String, Order> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends Order> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println("Saving to map");
        return entity;
    }

    @Override
    public Order findById(String id) {
        System.out.println("Finding from Map");
        return repository.get(id);
    }

    @Override
    public Iterable<Order> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    @Override
    public List<Order> findByUserName(final String userName) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getUser().getName().contains(userName))
                .collect(Collectors.toList());
    }


}
