package co.edu.cedesistemas.ecommerce.repository;

//import co.edu.cedesistemas.ecommerce.model.Address;
import co.edu.cedesistemas.ecommerce.model.document.Address;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class AddressJdbcRepository implements AddressRepository
{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AddressJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Address> findByName(String name) {
        return null;
    }

    @Override
    public <S extends Address> S save(S entity) {
        final String insertQ = "INSERT INTO address (id, name, description, city, countryISOCode, regionISOCode, phoneNumber, street1, street2, street3, zip)" +
                " VALUES (:id, :name, :description, :city, :countryISOCode, :regionISOCode, :phoneNumber, :street1, :street2, :street3, :zip )";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("description", entity.getDescription())
                .addValue("city", entity.getDescription())
                .addValue("countryISOCode", entity.getCountryISOCode())
                .addValue("regionISOCode", entity.getRegionISOCode())
                .addValue("phoneNumber", entity.getPhoneNumber())
                .addValue("street1", entity.getStreet1())
                .addValue("street2", entity.getStreet2())
                .addValue("street3", entity.getStreet3())
                .addValue("zip", entity.getZip());
        jdbcTemplate.update(insertQ, namedParameters);
        System.out.println("Updated Address in database");
        return entity;
    }

    @Override
    public Address findById(String id) {
        final String query = "SELECT * FROM address WHERE id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        System.out.println("Finding By Id from database: " + id);
        return jdbcTemplate.queryForObject(query, namedParameters, Address.class);
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public Iterable<Address> findAll() {
        return null;
    }
}
