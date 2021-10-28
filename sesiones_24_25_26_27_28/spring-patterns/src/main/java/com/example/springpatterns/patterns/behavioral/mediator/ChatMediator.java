package com.example.springpatterns.patterns.behavioral.mediator;

public interface ChatMediator {

    public void sendMessage(String message, AbstractUser user);

    public void addUser(AbstractUser user);

    public void removeUser(AbstractUser user);
}
