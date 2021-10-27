package com.example.springpatterns.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BookShop implements Iterable<Book>{

    List<Book> books;

    public BookShop(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShopIterator();
    }

    private class BookShopIterator implements Iterator<Book>{

        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return this.currentIndex < books.size();
        }

        @Override
        public Book next() {
        	if(!hasNext())
        		throw new NoSuchElementException();
        	
            return books.get(currentIndex++);
        }
    }
}
