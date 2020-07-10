package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController (final AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/users/addresses")
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        Address created = addressService.createAddress(address);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
