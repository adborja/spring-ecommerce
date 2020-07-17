package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.repository.mongo.AddressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(final AddressRepository repository) {
        this.repository = repository;
    }

    public Address createAddress(Address Address) {
        Address.setId(UUID.randomUUID().toString());
        return repository.save(Address);
    }

    public Address getById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public List<Address> getByName(final String name) {
        return repository.findByNameLike(name);
    }

    public Iterable<Address> getAllAddresss() {
        return repository.findAll();
    }

}