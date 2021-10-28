package com.example.springpatterns.patterns.structural.decorator.decoradores;


import com.example.springpatterns.patterns.structural.decorator.Photo;

public abstract class PhotoDecorator extends Photo {
	
	protected Photo photo; // podría ser una DigitalPhoto o un PhotoDecorator porque ambos extienden de Photo

	protected PhotoDecorator(Photo photo) {
		super();
		this.photo = photo;
	}
	
	
	

}
