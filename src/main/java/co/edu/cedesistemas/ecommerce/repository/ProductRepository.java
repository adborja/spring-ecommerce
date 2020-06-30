package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends Repository<Product, String> {
    List<Product> findByName(String name);
}
