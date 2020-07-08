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

    //@Override
    //public <S extends Address> S save(S entity) {
    //    return null;
    //}
    @Override
    public <S extends Address> S save(S entity) {
        final String insertQ = "INSERT INTO address (id, name, description)" +
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
