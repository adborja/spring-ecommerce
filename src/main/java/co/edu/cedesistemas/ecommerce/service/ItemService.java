package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.repository.mongo.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(final ItemRepository repository) {
        this.repository = repository;
    }

    public OrderItem createOrderItem(OrderItem orderItem){
     orderItem.setId(UUID.randomUUID().toString());
     return repository.save(orderItem);
     }

     public OrderItem getById(final String id) {
         return repository.findById(id).orElse(null);
     }

     /**public List<OrderItem> findAllByOrder(String id) {
        return repository.findAllByOrder(id);
     }**/

}
