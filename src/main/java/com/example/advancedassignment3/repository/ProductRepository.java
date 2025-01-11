package com.example.advancedassignment3.repository;

import com.example.advancedassignment3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
