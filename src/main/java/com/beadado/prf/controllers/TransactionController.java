package com.beadando.prf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beadando.prf.model.Transaction;
import com.beadando.prf.model.TransactionService;
import com.beadando.prf.model.ProductService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class TransactionController {

    TransactionService transactionService;
    ProductService productService;

    @Autowired
    public TransactionController(TransactionService transactionService, ProductService productService) {
        this.transactionService = transactionService;
        this.productService = productService;
    }

    @PostMapping(path="/transaction", consumes = "application/json")
    public String newTransaction(@RequestBody Transaction transaction) {
        try {
            this.transactionService.addTransaction(transaction);
            this.productService.reduceProductQuantity(transaction.getId());
            return "Success";
        } catch (Exception e) {
            System.out.println(e);
            return "Error during the create operation";
        }
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        try {
            return this.transactionService.getAllTransactions();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
}