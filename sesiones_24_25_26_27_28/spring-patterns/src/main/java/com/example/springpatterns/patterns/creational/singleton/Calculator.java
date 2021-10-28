package com.example.springpatterns.patterns.creational.singleton;

/**
 * Clase que implementa el patrón singleton
 */
public class Calculator {

	private static Calculator calculadora;
	
	private Calculator() {
		
	}
	
	public static Calculator getCalculator(){

		if(calculadora == null)
			calculadora = new Calculator();
		
		return calculadora;
	}
	
	
	
	
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
}
