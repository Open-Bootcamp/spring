package com.example.springpatterns.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Telegram implements ChatMediator{

	List<AbstractUser> users = new ArrayList<>();
	
	@Override
	public void sendMessage(String message, AbstractUser user) {
		for (AbstractUser abstractUser : users) {
			if(abstractUser != user)
				abstractUser.receive(message);
		}
	}

	@Override
	public void addUser(AbstractUser user) {
		this.users.add(user);
		
	}

	@Override
	public void removeUser(AbstractUser user) {
		this.users.remove(user);
	}

}
