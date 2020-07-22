package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.model.Store;
import co.edu.cedesistemas.ecommerce.model.User;

import java.util.List;
import java.util.Map;

public class ProductMapRepository implements ProductRepository{
    protected final Map<String, Product> repository;

    public ProductMapRepository(Map<String, Product> repository) {
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
