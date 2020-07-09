package co.edu.cedesistemas.ecommerce.service;


import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.repository.mongo.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(final AddressRepository repository) {
        this.repository = repository;
    }

    //Crear usuario
    public Address createAddress(Address address) {
        address.setId(UUID.randomUUID().toString());
        return repository.save(address);
    }

    //obtener un usuario dado su ID
    public Address getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Address> getAllAddress() {
        return repository.findAll();
    }




}
