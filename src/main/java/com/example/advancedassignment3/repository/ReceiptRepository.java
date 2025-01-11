package com.example.advancedassignment3.repository;

import com.example.advancedassignment3.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
