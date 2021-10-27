package com.example.springpatterns.patterns.behavioral.state;

public interface OrderState {

	void next(Order order);
	
	void previous(Order order);
}
