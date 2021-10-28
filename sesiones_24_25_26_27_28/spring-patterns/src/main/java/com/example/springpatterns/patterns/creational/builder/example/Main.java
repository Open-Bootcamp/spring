package com.example.springpatterns.patterns.creational.builder.example;

import java.util.Calendar;

public class Main {
	
	public static void main(String[] args) {
		
		StringBuilder articulo = new StringBuilder().append("Hola").append(" mundo").append(30);
		
		System.out.println(articulo);
		
		Calendar calendar = new Calendar.Builder().setCalendarType("gregory").setDate(2021, 7, 7).build();
		
		
	}

}
