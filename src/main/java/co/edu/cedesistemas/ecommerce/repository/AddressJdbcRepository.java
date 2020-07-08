package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

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
    public Address findById(String s) {
        return null;
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<Address> findAll() {
        return null;
    }
}
