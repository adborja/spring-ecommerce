package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.model.document.Product;
import co.edu.cedesistemas.ecommerce.service.ProductService;
import co.edu.cedesistemas.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(final ProductService productService) {
        
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable String id) {
        Product found = productService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/products/by-name")
    public ResponseEntity<?> getProductsByName(@RequestParam String name) {
        List<Product> Products = productService.getByName(name);
        return new ResponseEntity<>(Products, HttpStatus.OK);
    }

    @GetMapping("/products/by-description")
    public ResponseEntity<?> getProductsByDescription(@RequestParam String description) {
        Iterable<Product> Products = productService.getByDescription(description);
        return new ResponseEntity<>(Products, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductsById(@PathVariable String id) {
        productService.delete(id);
        return new ResponseEntity<>("deleted" +id, HttpStatus.OK);
    }

}