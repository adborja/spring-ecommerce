package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Store;
import co.edu.cedesistemas.ecommerce.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    private final StoreService storeService;

    public StoreController(final StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/stores")
    public ResponseEntity<?> createStore(@RequestBody Store store) {
        Store created = storeService.createStore(store);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<?> getStoreById(@PathVariable String id) {
        Store found = storeService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/stores/by-name")
    public ResponseEntity<?> getStoresByName(@RequestParam String name) {
        List<Store> stores = storeService.getByName(name);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/stores/by-type")
    public ResponseEntity<?> getStoresByType(@RequestParam Store.Type type) {
        Iterable<Store> stores = storeService.getStoresByType(type);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/stores")
    public ResponseEntity<?> getAllStores() {
        Iterable<Store> stores = storeService.getAllStores();

        if (stores == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
}
