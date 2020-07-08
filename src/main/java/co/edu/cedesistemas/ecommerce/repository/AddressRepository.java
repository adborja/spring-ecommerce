package co.edu.cedesistemas.ecommerce.repository;

//import co.edu.cedesistemas.ecommerce.model.Address;

import co.edu.cedesistemas.ecommerce.model.document.Address;

import java.util.List;

public interface AddressRepository extends Repository<Address, String> {
    List<Address> findByName(String name);
}
