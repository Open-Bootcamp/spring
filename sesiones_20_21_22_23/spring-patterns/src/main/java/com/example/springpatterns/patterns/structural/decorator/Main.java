package com.example.springpatterns.patterns.structural.decorator;


import com.example.springpatterns.patterns.structural.decorator.decoradores.EffectRetro;
import com.example.springpatterns.patterns.structural.decorator.decoradores.EffectVintage;

public class Main {

	public static void main(String[] args) {
		
		Photo selfie = new DigitalPhoto();
		System.out.println(selfie.show());
		
		
		Photo selfieRetro = new EffectRetro(selfie);
		System.out.println(selfieRetro.show());
		
		Photo selfieVintage = new EffectVintage(selfie);
		System.out.println(selfieVintage.show());
		
		Photo selfieRetroVintage = new EffectRetro(new EffectVintage(selfie));
		System.out.println(selfieRetroVintage.show());
		
		System.out.println("fin");
	}

}
