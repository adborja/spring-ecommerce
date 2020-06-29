package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductMapRepository implements ProductRepository {
    protected final Map<String, Product> repository;

    public ProductMapRepository(Map<String, Product> repository) {
        this.repository = repository;
    }

    public List<Product> findByName(final String name) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
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
