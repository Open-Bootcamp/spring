package com.example.springpatterns.patterns.creational.singleton;

public class Main {

	public static void main(String[] args) {

		Invoice invoice = new Invoice();
		invoice.calculateTotalPrice();
		
		Offer offer = new Offer();
		offer.calculateTotalOffer();
		
		if (invoice.calculator == offer.calculator) {
			System.out.println("Mismo objeto calculadora");
		}



	}

}
