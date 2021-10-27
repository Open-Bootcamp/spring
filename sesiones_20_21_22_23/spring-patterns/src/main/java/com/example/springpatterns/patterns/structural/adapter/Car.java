package com.example.springpatterns.patterns.structural.adapter;

public class Car implements Movable{

	private double speed;
	
	@Override
	public void speedUp(double quantity) {
		this.speed += quantity;
		
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	

}
