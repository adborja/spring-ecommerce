package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.repository.mongo.AddressRepository;
import co.edu.cedesistemas.ecommerce.repository.mongo.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository){

        this.repository = repository;
    }

    public Address createAddress(Address address) {
        address.setId(UUID.randomUUID().toString());
        return repository.save(address);
    }

}
