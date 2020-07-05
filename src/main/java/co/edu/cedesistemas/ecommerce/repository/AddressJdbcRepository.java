package co.edu.cedesistemas.ecommerce.repository;

import co.edu.cedesistemas.ecommerce.model.Address;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class AddressJdbcRepository implements AddressRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AddressJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends Address> S save(S entity) {

        return null;
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
