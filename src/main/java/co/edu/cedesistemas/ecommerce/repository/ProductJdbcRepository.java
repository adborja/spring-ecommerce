package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ProductJdbcRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
