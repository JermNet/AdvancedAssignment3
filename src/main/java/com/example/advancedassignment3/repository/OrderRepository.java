package com.example.advancedassignment3.repository;

import com.example.advancedassignment3.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
