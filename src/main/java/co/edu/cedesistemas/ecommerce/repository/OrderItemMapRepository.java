package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.OrderItem;
import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.Map;

public class OrderItemMapRepository implements OrderItemRepository{


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
}
