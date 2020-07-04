package co.edu.cedesistemas.ecommerce.repository.mongo;

import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByNameLike(String name);
    List<Product> findByDescriptionLike(String description);

}