package com.example.springpatterns.patterns.creational.builder;

public class Employee {

    private Long id;
    private String name;

    public static class Builder{

        private Long id;
        private String name;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

    }

}
