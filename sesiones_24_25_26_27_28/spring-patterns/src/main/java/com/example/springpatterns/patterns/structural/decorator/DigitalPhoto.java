package com.example.springpatterns.patterns.structural.decorator;

public class DigitalPhoto extends Photo{

	@Override
	public String show() {
		System.out.println("Ejecutando método show de foto original DigitalPhoto");

		return "Normal photo without edit";
	}
	
	@Override
	public double cost() {
		return 15;
	}


}
