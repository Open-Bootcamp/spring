package com.example.springpatterns.patterns.creational.factory;

public class Main {
	
	public static void main(String[] args) {
		// Las enum tienen un nombre y un valor ordinal numérico empezando en 0
		EmpleadoType[] types = EmpleadoType.values();
		
		EmpleadoFactory factory = new EmpleadoFactory();
		
		// MONTAR EQUIPO
		Empleado prog1 = factory.getEmpleado(EmpleadoType.PROGRAMADOR);
		// se puede combinar también con el patrón prototype a mayores
		// prog1.copy();
		
		
		Empleado prog2 = factory.getEmpleado(EmpleadoType.PROGRAMADOR);
		Empleado prog3 = factory.getEmpleado(EmpleadoType.PROGRAMADOR);
		
		Empleado mecanico1 = factory.getEmpleado(EmpleadoType.MECANICO);
		Empleado mecanico2 = factory.getEmpleado(EmpleadoType.MECANICO);
		
		
		
	}

}
