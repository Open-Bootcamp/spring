package com.example.springpatterns.patterns.creational.prototype.shopcart;

/*
 * Ejemplo para ilustrar un carrito
 * Diferente de prototype
 */
public class Main {
	
	public static void main(String[] args) {
		
		// te llega el id del frontend
		// recuperar le producto de DB a partir del id
		
		
		Product gamingPC = new Product();
		
		ShopCart cart = new ShopCart();
		cart.productos.add(gamingPC);
		cart.productos.remove(gamingPC);
		
		
		
	}

}
