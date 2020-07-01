package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.OrderItem;

import java.util.List;

public interface OrderItemRepository extends Repository <OrderItem, String>{
      List<OrderItem> findAllByOrder(String orderId);
}
