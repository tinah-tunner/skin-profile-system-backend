package com.carmina.skin_profile_system.service;

import com.carmina.skin_profile_system.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> searchProducts(String keyword);
}