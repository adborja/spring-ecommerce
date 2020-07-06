package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.repository.mongo.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository= repository;
    }

    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        return repository.save(product);
    }

    public List<Product> getByName(final String name){
        return repository.findByNameLike(name);
    }

    public List<Product> getByDescription(final String description){
        return repository.findByDescriptionLike(description);
    }


}
