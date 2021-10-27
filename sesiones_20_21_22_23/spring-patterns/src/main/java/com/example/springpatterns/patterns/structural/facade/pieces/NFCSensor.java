package com.example.springpatterns.patterns.structural.facade.pieces;

public class NFCSensor implements Sensor {

	@Override
	public void start() {
		System.out.println("Inicializando NFC");
		
	}

	@Override
	public void stop() {
		System.out.println("Desactivando NFC");		
	}
	


}
