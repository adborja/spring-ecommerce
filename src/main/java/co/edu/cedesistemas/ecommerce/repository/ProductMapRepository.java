package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.model.Store;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@Repository
//@Primary
public class ProductMapRepository implements ProductRepository {
    protected final Map<String, Product> repository;

    public ProductMapRepository(Map<String, Product> repository) {
        this.repository = repository;
        System.out.println(repository);
    }

    @Override
    public <S extends Product> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println(repository);
        return entity;
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

    @Override
    public List<Product> findByNameLike(String name) {
        return null;
    }
/*
    @Override
    public List<Product> findByDescriptionLike(String description) {
        return null;
    }

 */
}