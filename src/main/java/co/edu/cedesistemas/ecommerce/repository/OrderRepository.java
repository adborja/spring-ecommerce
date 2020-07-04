package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;

public interface OrderRepository extends Repository<Order, String> {
    List<Order> findByUser(String user);
}
