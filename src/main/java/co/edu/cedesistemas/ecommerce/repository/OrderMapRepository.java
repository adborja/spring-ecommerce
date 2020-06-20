package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;

import java.util.Map;

public class OrderMapRepository extends AbstractMapRepository<Order,String> {
    public OrderMapRepository(Map<String, Order> repository) {
        super(repository);
    }
}
