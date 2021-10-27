package com.example.springpatterns.patterns.behavioral.state;

public class ShippedState implements OrderState {

	@Override
	public void next(Order order) {

		System.out.println(
				String.format("Updating Order %d from %s to %s.", 
				order.getId(), 
				this.getClass().getSimpleName(), 
				DeliveredState.class.getSimpleName() 
				));
		
		order.setState(new DeliveredState());
	}

	@Override
	public void previous(Order order) {
		
		System.out.println(
				String.format("Updating Order %d from %s to %s.", 
				order.getId(), 
				this.getClass().getSimpleName(), 
				ProcessingState.class.getSimpleName() 
				));
		
		order.setState(new ProcessingState());
	}

}
