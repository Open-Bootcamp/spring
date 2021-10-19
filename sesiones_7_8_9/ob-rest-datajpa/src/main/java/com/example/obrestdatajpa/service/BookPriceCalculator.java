package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;

public class BookPriceCalculator {

    public double calculatePrice(Book book){
        double price = book.getPrice();

        if(book.getPages() > 300){
            price += 5;
        }
        // envio
        price += 2.99;
        return price;
    }
}
