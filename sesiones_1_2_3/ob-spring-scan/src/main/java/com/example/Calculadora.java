package com.example;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public Calculadora(){
        System.out.println("Ejecutando constructor CalculatorService");
    }
    public String holaMundo(){
        return "Hola mundo!";
    }
}
