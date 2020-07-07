package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
//@Repository
public class AddressJdbcRepository implements AddressRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AddressJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Address> S save(final S entity) {
        final String insertQ = "INSERT INTO address (id, name, description, city, countryISOCode, regionISOCode, phoneNumber, street1, street2, street3, zip)" +
                " VALUES (:id, :name, :description, :city, :countryISOCode, :regionISOCode, :phoneNumber, :street1, :street2, :street3, :zip)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("description", entity.getDescription())
                .addValue("city", entity.getCity())
                .addValue("countryISOCode", entity.getCountryISOCode())
                .addValue("regionISOCode", entity.getRegionISOCode())
                .addValue("phoneNumber", entity.getPhoneNumber())
                .addValue("street1", entity.getStreet1())
                .addValue("street2", entity.getStreet2())
                .addValue("street3", entity.getStreet3())
                .addValue("zip", entity.getZip());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated in database");
        return entity;
    }

    @Override
    public Address findById(final String id) {
        final String query = "SELECT * FROM address WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding from database");
        return jdbcTemplate.queryForObject(query, namedParameters, Address.class);
    }

    @Override
    public void remove(final String id) {
        final String query = "DELETE FROM address WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Removing in database");
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public Iterable<Address> findAll() {
        final String query = "SELECT * FROM address";
        System.out.println("Finding from database");
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Address.class));
    }


    private static class StoreRowMapper implements RowMapper<Address> {
        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address a = new Address();
            a.setId(rs.getString("id"));
            a.setName(rs.getString("name"));
            a.setDescription(rs.getString("description"));
            a.setCountryISOCode(rs.getString("countryISOCode"));
            a.setRegionISOCode(rs.getString("regionISOCode"));
            a.setPhoneNumber(rs.getString("phoneNumber"));
            a.setStreet1(rs.getString("street1"));
            a.setStreet2(rs.getString("street2"));
            a.setStreet3(rs.getString("street3"));
            a.setZip( rs.getString("zip"));

            return a;
        }
    }
}
