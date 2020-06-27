package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;

import java.util.List;

public interface OrderRepository extends Repository<Order, String> {
    List<Order> findByUserName(String userName);
}
