package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.repository.mongo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;


    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product){
        product.setId(UUID.randomUUID().toString());
        return repository.save(product);
    }

    public Product getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public List<Product> getByName(final String name) {
        return repository.findByNameLike(name);
    }

    public List<Product> getByDescription(final String description) {
        return repository.findByDescriptionLike(description);
    }

    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

}
