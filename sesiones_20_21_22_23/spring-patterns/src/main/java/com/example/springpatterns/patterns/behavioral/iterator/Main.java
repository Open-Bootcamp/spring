package com.example.springpatterns.patterns.behavioral.iterator;

import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
        Book book1 = new Book("5656435", "Hawkins", 2021 );
        Book book2 = new Book("124234fdfg", "Tolle", 1997 );
        Book book3 = new Book("42536357657", "David", 1500 );

        BookShop books = new BookShop();
        books.addBook(book1);
        books.addBook(book2);
        books.addBook(book3);


        Iterator<Book> iterador = books.iterator();
        while (iterador.hasNext()){
            Book book = iterador.next();
            System.out.println(book);
        }
        System.out.println("============");

        for (Book book: books) {
            System.out.println(book);
        }
	}

}
