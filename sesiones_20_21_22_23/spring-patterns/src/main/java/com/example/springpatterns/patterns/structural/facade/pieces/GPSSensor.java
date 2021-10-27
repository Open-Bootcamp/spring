package com.example.springpatterns.patterns.structural.facade.pieces;

public class GPSSensor implements Sensor {

	@Override
	public void start() {
		System.out.println("Inicializando GPS");
		
	}

	@Override
	public void stop() {
		System.out.println("Desactivando GPS");		
	}

}
