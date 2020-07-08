package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
//@Primary
public class ProductJdbcRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }

    @Override
    public List<Product> findByName(String name) {
        final String query = "SELECT * FROM product WHERE name LIKE :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, Product.class);
    }

    @Override
    public List<Product> findByDescription(String description) {
        final String query = "SELECT * FROM product WHERE description LIKE :description";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("description", description);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, Product.class);
    }

    @Override
    public <S extends Product> S save(S entity) {
        final String insertQ = "INSERT INTO product (id, name, description)" +
                " VALUES (:id, :name, :description)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("description", entity.getDescription());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated Product in database");
        return entity;
    }

    @Override
    public Product findById(String id) {
            final String query = "SELECT * FROM product WHERE id = :id";
            SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
            System.out.println("Finding By Id from database: " + id);
            return jdbcTemplate.queryForObject(query, namedParameters, Product.class);
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<Product> findAll() {
        final String query = "SELECT * FROM product";
        System.out.println("Finding Products from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class));
    }
}
