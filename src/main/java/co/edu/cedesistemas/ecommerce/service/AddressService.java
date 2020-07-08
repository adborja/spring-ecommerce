package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService (AddressRepository repository) {
        this.repository = repository;
    }

    public Address createAddress(Address address){
        address.setId(UUID.randomUUID().toString());
        return repository.save(address);
    }

    public Address getById(final String id) {
        return repository.findById(id);
    }
}
