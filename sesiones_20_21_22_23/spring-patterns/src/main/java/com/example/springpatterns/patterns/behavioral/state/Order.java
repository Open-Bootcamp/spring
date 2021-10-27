package com.example.springpatterns.patterns.behavioral.state;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	// atributos
	private Long id;
	private LocalDateTime date;
	private List<Product> products = new ArrayList<>();
	private OrderState state = new ProcessingState(); // State
	
	
	// constructores
	public Order(Long id, LocalDateTime date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	// custom logic (comportamiento)
	public void nextState(){
		state.next(this);
	}
	
	public void previousState() {
		state.previous(this);
	}
	
	
	
	
	// getter setter
	public Long getId() {
		return id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public List<Product> getProducts() {
		return products;
	}
	public OrderState getState() {
		return state;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setState(OrderState state) {
		this.state = state;
	}

}
