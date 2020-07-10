package co.edu.cedesistemas.ecommerce.service;



import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.repository.mongo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends Product {
    private  final ProductRepository repository;

@Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
         return repository.save(product);
    }

    public Product getById(final String id) {

    return repository.findById(id).orElse(null);
    }

    public List<Product> getByName(String name) {
        return repository.findByNameLike(name);
    }

    public List<Product> getByDescription(String description) {
        return repository.findByDescriptionLike(description);
    }

    public Iterable<Product> getAllProduct() {
        return repository.findAll();
    }

    public void deleteById(final String id) {
        repository.deleteById(id);
    }

    public ProductRepository getRepository() {
        return repository;
    }
}
