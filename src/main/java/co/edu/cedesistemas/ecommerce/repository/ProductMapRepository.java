package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class ProductMapRepository implements ProductRepository{

    protected final Map<String, Product> repository;

    public ProductMapRepository(Map<String, Product> repository){
        this.repository = repository;
    }

    @Override
    public <S extends Product> S save(S entity) {
        return null;
    }

    @Override
    public Product findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }
}
