package com.example.springpatterns.patterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;


public class Invoice {

	List<Double> prices = new ArrayList<>();
	
	Calculator calculator = Calculator.getCalculator();
//	Calculator calculator = new Calculator();
	
	
	public double calculateTotalPrice(){
		
		// algoritmo que utiliza la calculadora
		// calculator
		
		
		return 0d;
	}
}
