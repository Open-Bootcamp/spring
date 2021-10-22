package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Car;
import com.example.demo.dto.CarListDTO;
import com.example.demo.dto.CountDTO;
import com.example.demo.dto.MessageDTO;
import com.example.demo.service.CarService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class CarController {
	
	private final Logger log = LoggerFactory.getLogger(CarController.class);

	// dependencia
	private CarService carService; 
	
	public CarController(CarService carService) { // spring inyecta la dependencia
		this.carService = carService;
	}
	

	/* ============= SPRING CRUD METHODS ================ */
	
	/**
	 * http://localhost:8080/api/cars/1
	 */
	@GetMapping("/cars/{id}")
	@ApiOperation("Buscar coche por id")
	public ResponseEntity<Car> findById(@ApiParam("Clave primaria car") @PathVariable Long id) {
		log.info("REST request to find one car");

		Optional<Car> carOpt = this.carService.findById(id);
		
		// opcion 1
		if (carOpt.isPresent()) 
			return ResponseEntity.ok(carOpt.get());
		
		return ResponseEntity.notFound().build();
		
		// opcion 2
//		return carOpt
//				.map(
//						car -> ResponseEntity.ok(car))
//				.orElseGet(
//						() -> ResponseEntity.notFound().build()
//				);
		
	}
	
	/**
	 * http://localhost:8080/api/cars
	 */
	@GetMapping("/cars")
	public List<Car> findAll(){
		log.info("REST request to find all cars");
		return this.carService.findAll();
	}
	
	// create one
	@PostMapping("/cars")
	public ResponseEntity<Car> create(@RequestBody Car car){
		log.info("REST request to create a new car");
		
		if (car.getId() != null) { // HAY ID - EL COCHE YA EXISTE NO PUEDO CREARLO DE NUEVO
			log.warn("Trying to create a new car with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(this.carService.save(car));
		
	}
	
	// update 
	@PutMapping("/cars")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		log.info("REST request to update an existing car");
		if (car.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE EL COCHE A ACTUALIZAR
			log.warn("Trying to update an existing car without id");
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.carService.save(car));
		
	}
	
	// delete one
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Car> delete(@PathVariable Long id){
		log.info("REST request to delete an existing car");
		
		this.carService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// delete all
	
	@DeleteMapping("/cars")
	public ResponseEntity<Car> deleteAll(){
		log.info("REST request to delete all cars");
		
		this.carService.deleteAll();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/cars/count")
	public ResponseEntity<CountDTO> count(){
		log.info("REST request to count all cars");
		Long count = this.carService.count();
		CountDTO dto = new CountDTO(count);
		dto.setMessage("Que tenga usted un feliz dia :)");
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/cars/hello")
	public ResponseEntity<String> hello(){
		return ResponseEntity.ok("Hello");
	}
	
	@GetMapping("/cars/hello2")
	public ResponseEntity<MessageDTO> hello2(){
		return ResponseEntity.ok(new MessageDTO("Hello"));
	}
	
	// @PostMapping("/cars/deletemany")
	@DeleteMapping("/cars/deletemany")
	public ResponseEntity<Car> deleteMany(@RequestBody CarListDTO carListDto){
		
		this.carService.deleteAll(carListDto.getCars());
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/cars/deletemany/{ids}")
	public ResponseEntity<Car> deleteMany(@PathVariable List<Long> ids){
		this.carService.deleteAllById(ids);
		
		return ResponseEntity.noContent().build();
	} 
	
	
	
	/* ============= CUSTOM CRUD METHODS ================ */

	
	@GetMapping("/cars/manufacturer/{manufacturer}/model/{model}")
	public List<Car> findByManufacturerAndModel(@PathVariable String manufacturer,
			@PathVariable String model){
		return this.carService.findByManufacturerAndModel(manufacturer, model);
	}
	
	@GetMapping("/cars/doors/{doors}")
	// @ApiIgnore
	@ApiOperation("Buscar coches filtrando por numero puertas")
	public List<Car> findByDoors(@PathVariable Integer doors){
		log.info("REST request to find cars by num doors");
		return this.carService.findByDoors(doors);
	}
	
	@GetMapping("/cars/doors-gte/{doors}")
	public List<Car> findByDoorsGreaterThanEqual(@PathVariable Integer doors){
		return this.carService.findByDoorsGreaterThanEqual(doors);
	}
	
	
	
	
	
	
	
	
	
	
	
}
