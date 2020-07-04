package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Store;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
//@Repository
//@Primary
public class StoreJdbcRepository implements StoreRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StoreJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Store> S save(final S entity) {
        final String insertQ = "INSERT INTO store (id, name, phone, address, type, createdAt)" +
                " VALUES (:id, :name, :phone, :address, :type, :createdAt)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("phone", entity.getPhone())
                .addValue("address", entity.getAddress())
                .addValue("type", entity.getType().name())
                .addValue("createdAt", entity.getCreatedAt());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
    }

    @Override
    public Store findById(final String id) {
        final String query = "SELECT * FROM store WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, Store.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM store WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<Store> findAll() {
        final String query = "SELECT * FROM store";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Store.class));
    }

    @Override
    public List<Store> findByName(final String name) {
        final String query = "SELECT * FROM store WHERE name LIKE :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForList(query, namedParameters, Store.class);
    }

    @Override
    public List<Store> findByType(Store.Type type) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate.getJdbcTemplate())
                .withProcedureName("get_stores_by_type")
                .returningResultSet("stores", new StoreRowMapper());

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("t", type.name());

        return (List<Store>) jdbcCall.execute(in).get("stores");
    }

    private static class StoreRowMapper implements RowMapper<Store> {
        @Override
        public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
            Store store = new Store();
            store.setId(rs.getString("id"));
            store.setName(rs.getString("name"));
            store.setAddress(rs.getString("address"));
            store.setPhone(rs.getString("phone"));
            store.setType(Store.Type.valueOf(rs.getString("type")));
            store.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
            Timestamp updatedAt = rs.getTimestamp("updatedAt");
            store.setUpdatedAt(updatedAt != null ? updatedAt.toLocalDateTime() : null);
            return store;
        }
    }
}
