package com.example.springpatterns.patterns.behavioral.state;

public class DeliveredState implements OrderState {

	@Override
	public void next(Order order) {
		System.out.println("Order delivered, ends!");

	}

	@Override
	public void previous(Order order) {
		System.out.println(
				String.format("Updating Order %d from %s to %s.", 
				order.getId(), 
				this.getClass().getSimpleName(), 
				ShippedState.class.getSimpleName() 
				));
		
		order.setState(new ShippedState());
	}

}
