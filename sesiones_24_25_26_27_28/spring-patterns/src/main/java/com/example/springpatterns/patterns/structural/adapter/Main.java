package com.example.springpatterns.patterns.structural.adapter;

public class Main {
	
	public static void main(String[] args) {
		
        Movable toyota = new Car();
        toyota.speedUp(50);
        
//        Movable johndeere = new Tractor();
//        johndeere.speedUp(50);
        
        Movable tractor = new TractorAdapter();
        tractor.speedUp(50);
        
	}

}
