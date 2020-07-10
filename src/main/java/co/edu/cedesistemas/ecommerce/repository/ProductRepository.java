package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.document.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends Repository<Product, String> {
   List<Product> findByNameLike(String name);
   //List<Product> findByDescriptionLike(String description);

}
