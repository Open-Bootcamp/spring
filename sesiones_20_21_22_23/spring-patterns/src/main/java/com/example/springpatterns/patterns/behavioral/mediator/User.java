package com.example.springpatterns.patterns.behavioral.mediator;

public class User extends AbstractUser{

	protected User(ChatMediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String message) {
		this.mediator.sendMessage(message, this);
	}

	@Override
	public void receive(String message) {
		System.out.println("received!");
		
	}

}
