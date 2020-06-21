package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;

import java.util.Map;

public class OrderItemMapRepository extends AbstractMapRepository<OrderItem, String> {

    public OrderItemMapRepository(Map<String, OrderItem> repository){
        super(repository);

    }
}
