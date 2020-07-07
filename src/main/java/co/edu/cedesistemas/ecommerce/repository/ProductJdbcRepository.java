package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Repository
public class ProductJdbcRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Product> S save(final S entity) {
        final String insertQ = "INSERT INTO product (id, name, description)" +
                " VALUES (:id, :name, :description)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("description", entity.getDescription());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
    }

    @Override
    public Product findById(final String id) {
        final String query = "SELECT * FROM product WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, Product.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM product WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<Product> findAll() {
        final String query = "SELECT * FROM product";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class));
    }


    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product p = new Product();
            p.setId(rs.getString("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));

            return p;
        }
    }
}
