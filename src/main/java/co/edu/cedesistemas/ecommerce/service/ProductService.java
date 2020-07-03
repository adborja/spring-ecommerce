package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.repository.ProductRepository;
import java.util.UUID;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository= repository;
    }

    public Product createProduct(Product product){
        product.setId(UUID.randomUUID().toString());
        return repository.save(product);
    }
}
