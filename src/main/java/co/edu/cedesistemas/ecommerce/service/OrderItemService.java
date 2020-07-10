package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderItemService {
    private final OrderItemRepository repository;

    public OrderItemService(final OrderItemRepository repository) {
        this.repository = repository;
    }

    public OrderItem createOrderItem(OrderItem orderItem){
     orderItem.setId(UUID.randomUUID().toString());
     return repository.save(orderItem);
     }

     public OrderItem getById(final String id) {
         return repository.findById(id).orElse(null);
     }

    //Tiene comentarios porque genera error cuando se ejecuta el test.
    //No puede resolver OrderItem y sale error.
     /**public List<OrderItem> findAllByOrder(String id) {
        return repository.findAllByOrder(id);
     }**/

}
