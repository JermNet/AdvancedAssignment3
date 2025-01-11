package com.example.advancedassignment3.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ReceiptTable")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Receipt should only be a receipt for one order at a time, so this relationship makes the most sense
    @OneToOne
    private Order order;
    // Using built in date object since that makes perfect sense for a receipt
    private Date date;
    private double totalAmount;

    public Receipt(long id, Order order, Date date, double totalAmount) {
        this.id = id;
        this.order = order;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Receipt(Order order, Date date, double totalAmount) {
        this.order = order;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Receipt() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
