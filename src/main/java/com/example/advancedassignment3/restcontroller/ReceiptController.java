package com.example.advancedassignment3.restcontroller;

import com.example.advancedassignment3.model.Receipt;
import com.example.advancedassignment3.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Not really any comments here since I did product controller first, and it's the same concepts here. Take a look at that one for
// explanations on the methods.
@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping
    public ResponseEntity<List<Receipt>> getAllReceipts() {
        List<Receipt> receipts = receiptRepository.findAll();
        return new ResponseEntity<>(receipts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable long id) {
        Optional<Receipt> receipt = receiptRepository.findById(id);
        return receipt.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Receipt> createReceipt(@RequestBody Receipt receipt) {
        Receipt savedReceipt = receiptRepository.save(receipt);
        return new ResponseEntity<>(savedReceipt, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receipt> updateReceipt(@PathVariable long id, @RequestBody Receipt receiptDetails) {
        return receiptRepository.findById(id).map(receipt -> {
            receipt.setOrder(receiptDetails.getOrder());
            receipt.setDate(receiptDetails.getDate());
            receipt.setTotalAmount(receiptDetails.getTotalAmount());
            Receipt updatedReceipt = receiptRepository.save(receipt);
            return new ResponseEntity<>(updatedReceipt, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Receipt> deleteReceipt(@PathVariable long id) {
        if (receiptRepository.existsById(id)) {
            receiptRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
