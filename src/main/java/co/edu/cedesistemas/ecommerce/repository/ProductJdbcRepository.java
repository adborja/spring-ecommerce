package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class ProductJdbcRepository implements ProductRepository {
    @Override
    public <S extends Product> S save(final S entity) {
        /*final String insertQ = "INSERT INTO product (id, name, description)" +
                " VALUES (:id, :name, :description)";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("description", entity.getDescription());

        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");*/
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

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}
