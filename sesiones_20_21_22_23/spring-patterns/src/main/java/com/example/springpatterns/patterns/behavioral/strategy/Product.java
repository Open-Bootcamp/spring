package com.example.springpatterns.patterns.behavioral.strategy;

public class Product {

    private String sku;
    private double price;

    public Product(String sku, double price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
