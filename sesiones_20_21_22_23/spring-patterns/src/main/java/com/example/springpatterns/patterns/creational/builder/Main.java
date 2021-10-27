package com.example.springpatterns.patterns.creational.builder;

public class Main {
	
	public static void main(String[] args) {
		
		User user = new User.Builder().setId(1L).build();
		
		User user2 = new User.Builder().setId(1L).setEmail("alan@alan").build();
		
		User user3 = new User.Builder().setId(1L).setEmail("alan@alan").setFirstName("alan").build();
		
		User user4 = new User.Builder().setEmail("alan@alan").setFirstName("alan").setLastName("sastre").build();
		
		// user4 = userDAO.create(user4);
		
		
		
		
	}

}
