package com.carmina.skin_profile_system.repository;

import com.carmina.skin_profile_system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByCategoryContainingIgnoreCase(
            String category
    );

    List<Product> findByNameContainingIgnoreCase(
            String name
    );
}