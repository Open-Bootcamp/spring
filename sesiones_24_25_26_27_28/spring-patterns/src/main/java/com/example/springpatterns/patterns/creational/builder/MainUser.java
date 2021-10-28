package com.example.springpatterns.patterns.creational.builder;

public class MainUser {

    public static void main(String[] args) {

        User user1 = new User.Builder().setId(1L).build();

        User user2 = new User.Builder().setId(1L).setFirstName("Alan").build();

        User user3 = new User.Builder().setId(1L).setFirstName("Alan").setLastName("Sastre").build();


        User user4 = new User.Builder().setId(1L).setFirstName("Alan").setLastName("Sastre").setEmail("asasa@asas.com").build();

        User user5 = new User.Builder()
                .setId(1L).setFirstName("Alan").setLastName("Sastre")
                .setEmail("asasa@asas.com").setMarried(false)
                .build();

        User user6 = new User.Builder()
                .setMarried(true).setFirstName("Alan").setLastName("Sastre")
                .setEmail("asasa@asas.com").setId(6L)
                .build();


    }
}
