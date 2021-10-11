package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    // 1. atributos
    Calculadora calculadora;

    //2. constructores

    public GestorFacturas(Calculadora calculadora){
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
    }

    // 3. metodos....
}
