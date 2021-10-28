package com.example.springpatterns.patterns.creational.factory;

public class EmpleadoFactory {
	
	/**
	 * Devuelve un empleado del tipo solicitado
	 * @return
	 */
	public Empleado getEmpleado(EmpleadoType type){
		
		// opcion 1 
//		if (type == "MECANICO") {
//			return new Mecanico();
//		} else if(type == "PROGRAMADOR"){
//			return new Programador();
//		}else{
//			throw new IllegalArgumentException("Tipo empleado no existe " + type);
//		}
		
//		 opcion 2
//		switch (type) {
//		case "MECANICO":
//			return new Mecanico();
//		case "PROGRAMADOR":
//			return new Programador();
//
//		default:
//			throw new IllegalArgumentException("Tipo empleado no existe " + type);
//		}
		
		// opcion 3
		switch (type) {
		case MECANICO:
			return new Mecanico();
			// ejemplo de como conectar con la fachada
			// return SmartPhoneFacade.startSmartPhone();
		case PROGRAMADOR:
			
			return new Programador();

		default:
			throw new IllegalArgumentException("Tipo empleado no existe " + type);
		}
		
	}

}
