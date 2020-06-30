package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

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
        return repository.findById(id);
    }

    public void delete(final String id) {
        repository.remove(id);
    }

    public List<Product> getByName(final String name) {
        return repository.findByName(name);
    }

    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

}
