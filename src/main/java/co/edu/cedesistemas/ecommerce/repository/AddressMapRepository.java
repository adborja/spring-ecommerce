package co.edu.cedesistemas.ecommerce.repository;


import co.edu.cedesistemas.ecommerce.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressMapRepository implements AddressRepository {

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
