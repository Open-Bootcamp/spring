package com.example.springpatterns.patterns.structural.decorator.decoradores;


import com.example.springpatterns.patterns.structural.decorator.Photo;

public class EffectRetro extends PhotoDecorator{

	public EffectRetro(Photo photo) {
		super(photo);
	}

	@Override
	public String show() {
		// decorar la foto
		this.photo.setBrightness(50);
		this.photo.setContrast(20);
		return this.photo.show() + " + Retro";
	}
	
	@Override
	public double cost() {
		return this.photo.cost() + 20;
	}

}
