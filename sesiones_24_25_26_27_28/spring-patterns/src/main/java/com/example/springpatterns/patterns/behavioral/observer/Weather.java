package com.example.springpatterns.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Weather que notifica del cambio de tiempo a los observadores
 *
 * One Weather - To - Many Observers
 *
 */
public class Weather {
 
    private WeatherType currentWeather;

    // One To Many
    private final List<WeatherObserver> observers;

    public Weather(){
        this.observers = new ArrayList<>();
    }

    public void addObserver(WeatherObserver obs){
        System.out.println("Added observer");
        this.observers.add(obs);
    }

    public void removeObserver(WeatherObserver obs){
        System.out.println("Removed observer");
        this.observers.remove(obs);
    }

    /**
     * Cambia el tiempo y notifica a los observadores asociados
     * @param currentWeather
     */
    void changeWeather(WeatherType currentWeather){
        this.currentWeather = currentWeather; // cambia
        this.notifyObservers(); // notifica
    }

    /**
     * Notifica del cambio de tiempo a los observadores
     */
    private void notifyObservers(){
        // polimorfismo, se tratan los observadores como objetos WeatherObserver
        for (WeatherObserver observer: this.observers) {
            observer.update(this.currentWeather);
        }
    }
}
