package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product1) {
        product1.setId(UUID.randomUUID().toString());
        return repository.save(product1);
    }
}
