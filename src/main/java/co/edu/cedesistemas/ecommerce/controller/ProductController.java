package co.edu.cedesistemas.ecommerce.controller;

import co.edu.cedesistemas.ecommerce.model.document.Product;
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

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        Iterable<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable String id) {
        Product found = productService.getById(id);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/products/by-description")
    public ResponseEntity<?> getByDescription(@RequestParam String desc) {
        List<Product> products = productService.getByDescription(desc);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/by-name")
    public ResponseEntity<?> getProductsByName(@RequestParam String name) {
        List<Product> products = productService.getByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable String id) {
        productService.delete(id);
        return new ResponseEntity<>("Deleted: " + id, HttpStatus.OK);
    }


}
