package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;

import java.util.Map;

public class ProductMapRepository extends AbstractMapRepository<Product, String>{

    public ProductMapRepository(Map<String, Product> repository) {
        super(repository);
    }
}
