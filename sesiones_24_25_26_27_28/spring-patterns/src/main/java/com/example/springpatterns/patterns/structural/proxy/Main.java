package com.example.springpatterns.patterns.structural.proxy;

public class Main {

    public static void main(String[] args) {

        Image img = new ProxyImage("holamundo.jpg");

        // El proxy crea el objeto real por debajo la primera vez
        img.show();

        System.out.println("================");
        // El proxy ya tiene el objeto real creado no lo crea de nuevo
        img.show();

    }
}
