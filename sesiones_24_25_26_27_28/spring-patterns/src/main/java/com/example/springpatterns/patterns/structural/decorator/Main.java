package com.example.springpatterns.patterns.structural.decorator;


import com.example.springpatterns.patterns.structural.decorator.decoradores.EffectRetro;
import com.example.springpatterns.patterns.structural.decorator.decoradores.EffectVintage;

public class Main {

	public static void main(String[] args) {

		// Se crea la foto original
		Photo selfie = new DigitalPhoto();
		System.out.println(selfie.show());

		System.out.println("============");
		// Se aplica un decorador a la foto original
		Photo selfieRetro = new EffectRetro(selfie);
		System.out.println(selfieRetro.show()); // decora la funcionalidad show original

		System.out.println("============");

		Photo selfieVintage = new EffectVintage(selfie);
		System.out.println(selfieVintage.show());

		System.out.println("============");
		Photo selfieRetroVintage = new EffectRetro(new EffectVintage(selfie));
		System.out.println(selfieRetroVintage.show());
		
		System.out.println("fin");
	}

}
