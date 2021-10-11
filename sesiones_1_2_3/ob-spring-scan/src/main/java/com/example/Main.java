package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // CONCEPTO 1: cómo obtener beans de Spring

        // Opción 1. Crear un objeto de forma normal
        // Calculadora service = new Calculadora();

        // Opción 2. Recibir un objeto de Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");
        String texto = calculadora.holaMundo();
        System.out.println(texto);
        // Se puede volver a obtener
        // OJO: se recupera el mismo objeto
        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        texto = calculadora.holaMundo();
        System.out.println(texto);

        // CONCEPTO 2: cargar un bean dentro de otro bean
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());


        // CONCEPTO 3: scope o alcance
        // los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación
        // podemos cambiarlo a scope="prototype" si queremos que se cree un nuevo objeto cada vez
        // verificarlo viendo cómo se ejecuta varias veces un constructor


    }
}
