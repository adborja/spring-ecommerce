package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import co.edu.cedesistemas.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductMapRepository implements ProductRepository {
    protected final Map<String, Product> repository;

    public ProductMapRepository(Map<String, Product> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends Product> S save(S entity) {
        repository.put(entity.getId(), entity);
        System.out.println("Saving to map");
        return entity;
    }

    @Override
    public Product findById(String id) {
        System.out.println("Finding from Map");
        return repository.get(id);
    }

    @Override
    public Iterable<Product> findAll() {
        System.out.println("Finding from Map");
        return repository.values();
    }

    @Override
    public void remove(String id) {
        System.out.println("Removing in Map");
        repository.remove(id);
    }

    public List<Product> findByName(final String name) {
        System.out.println("Finding from Map");
        return repository.values().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

}
