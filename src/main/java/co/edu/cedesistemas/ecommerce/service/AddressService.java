package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.repository.mongo.AddressRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(final AddressRepository repository){
        this.repository = repository;
    }

    public Address createAddress(Address address){
        address.setId(UUID.randomUUID().toString());
        return repository.save(address);
    }

    public Address getById(final String id){
        return repository.findById(id).orElse(null);
    }

    public Iterable<Address> getAllAddress(){
        return repository.findAll();
    }


}
