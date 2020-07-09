package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Address;
import co.edu.cedesistemas.ecommerce.model.document.Order;
import co.edu.cedesistemas.ecommerce.model.document.OrderItem;
import co.edu.cedesistemas.ecommerce.service.AddressService;
import co.edu.cedesistemas.ecommerce.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService aService;

    public AddressController(final AddressService oService) {
        this.aService = oService;
    }

    @PostMapping("/users/addresses")
    public ResponseEntity<?> createAddress(@RequestBody Address a) {
        Address created = aService.createAddress(a);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

}
