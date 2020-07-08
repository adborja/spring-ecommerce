package co.edu.cedesistemas.ecommerce.repository.mongo;

import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
