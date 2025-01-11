package com.example.advancedassignment3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="OrderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // An Order is just a collection of products, so this is the relationship that chose so it makes the most sense
    @OneToMany
    private List<Product> products;
    private double totalAmount;

    public Order(long id, List<Product> products, double totalAmount) {
        this.id = id;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public Order(List<Product> products, double totalAmount) {
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public Order() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
