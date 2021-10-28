package com.example.springpatterns.patterns.behavioral.strategy;

public class Main {

	
	public static void main(String[] args) {

        // preparar los datos
        ShopCart cart = new ShopCart();

        Product product1 = new Product("1422342342DSFDSF", 9.99);
        Product product2 = new Product("1422342342DSFDSF", 99.99);

        cart.addProduct(product1);
        cart.addProduct(product2);

        // Crear y ejecutar estrategia (método de pago): PayPal
        cart.pay(new PayPalStrategy("","",""));

        // Crear y ejecutar estrategia (método de pago): Tarjeta de crédito
        cart.pay(new CreditCardStrategy("","","", ""));

        // Si la interfaz tiene un solo método entonces es una interfaz funcional y por
        // tanto se pueden utilizar lambdas, ahorrando así tener que crear las implementaciones estrategia
        cart.pay(
                (amount) -> System.out.println(amount)
        );
	}
}
