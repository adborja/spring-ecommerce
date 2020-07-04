package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.List;

public interface ProductRepository extends Repository<Product, String> {
    List<Product> findByName(String name);
}
