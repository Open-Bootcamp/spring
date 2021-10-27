
## Patrones de diseño

No son código en sí, son una forma de estructurar el código con el objeto de resolver un 
problema común.

Patrones a explorar: 

* Plantilla (Template)
* Cadena de responsabilidad (Chain of responsibility)
* Estrategia (Strategy)
* Proxy
* Constructor (Builder)
* Observador (Observer)
* Decorador (Decorator)

## Tipos de patrones 

* **Creacionales**
  * Constructor (Builder)
* **Estructurales**
  * Proxy
  * Decorador
* **Comportamiento**
  * Template
  * Chain of responsibility
  * Strategy
  * Observer

## Objetivos generales

* Obtener bajo acoplamiento 
* Reutilización de código
* Flexibilidad
* Escalabilidad
* Eficiencia
* Estándar de buenas prácticas
* Favorece el testing
* Mayor calidad

# Recursos de interés 

https://refactoring.guru/design-patterns/catalog

https://github.com/eugenp/tutorials/tree/master/patterns

https://www.baeldung.com/spring-framework-design-patterns

## 1. Patrón Plantilla 

* Desacoplar código 
* Reutilizar código

## 2. Patrón cadena de responsabilidad 

En Spring Security tenemos los filtros 

Objetivos:
* Reducir el acoplamiento
* Flexibilidad al permitir cambiar responsabilidad
* Componer objetos que en su totalidad resuelven una unidad de trabajo

A tener en cuenta: 

* Cada elemento de la cadena de responsabilidad (Manejador) tiene su propia implementación
* Cada manejador hace referencia al siguiente manejador
* No deberían formarse ciclos recursivos 