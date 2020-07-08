package co.edu.cedesistemas.ecommerce.repository.mongo;

import co.edu.cedesistemas.ecommerce.model.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
}