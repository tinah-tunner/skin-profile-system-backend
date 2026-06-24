package com.carmina.skin_profile_system.controller;

import com.carmina.skin_profile_system.entity.Product;
import com.carmina.skin_profile_system.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    // ADMIN ONLY

    @PostMapping("/admin/products")
    public Product createProduct(
            @RequestBody Product product) {

        return productService.createProduct(product);
    }

    @PutMapping("/admin/products/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        return productService.updateProduct(
                id,
                product
        );
    }

    @DeleteMapping("/admin/products/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok(
                "Product deleted successfully"
        );
    }

    // EVERYONE CAN VIEW

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(
            @RequestParam String keyword) {

        return productService.searchProducts(
                keyword
        );
    }
}