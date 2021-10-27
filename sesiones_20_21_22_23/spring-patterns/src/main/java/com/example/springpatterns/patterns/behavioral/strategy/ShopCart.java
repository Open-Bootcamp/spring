package com.example.springpatterns.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShopCart {

    private List<Product> products;

    public ShopCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    // pagar utilizando una estrategia de pago
    public void pay(PaymentStrategy paymentMethod){
    	Double result = products.stream().map(x -> x.getPrice()).reduce(Double::sum).orElse(0d);
        double amount = 0;
        for (Product product : products) {
            amount += product.getPrice();
        }

        paymentMethod.pay(amount);
    }

}
