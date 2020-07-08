package co.edu.cedesistemas.ecommerce.controller;



import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.User;
import co.edu.cedesistemas.ecommerce.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AddressController {
    private final AddressService addressService;
    public AddressController(final AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/users/addresses")
    public ResponseEntity<?> AddressUser(@RequestBody Address address) {
        Address created = addressService.createAddress(address);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

}