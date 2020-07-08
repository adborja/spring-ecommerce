package co.edu.cedesistemas.ecommerce.service;

import co.edu.cedesistemas.ecommerce.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService (AddressRepository repository) {
        this.repository = repository;
    }
}
