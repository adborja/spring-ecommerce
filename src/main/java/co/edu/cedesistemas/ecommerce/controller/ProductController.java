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
    public ProductController(final ProductService productService) {this.productService = productService;}

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id){
        Product found = productService.getById(id);

        if (found == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/products/name")
    public ResponseEntity<?> getProductByName(@RequestParam String name){
        List<Product> products = productService.getByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/description")
    public ResponseEntity<?> getProductByDescription(@RequestParam String description){
        List<Product> products = productService.getByDescription(description);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        Product deleted = productService.getById(id);
        productService.delete(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        Iterable<Product> products = productService.getAllProducts();
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
