package com.example.springpatterns.patterns.structural.facade.pieces;

import java.util.ArrayList;
import java.util.List;

public class SmartPhone {
	
	private Battery battery;
	private CPU cpu;
	private Screen screen;
	private List<Sensor> sensors = new ArrayList<>();
	private Boolean on;
	
	
	public SmartPhone(Battery battery, CPU cpu, Screen screen, List<Sensor> sensors) {
		super();
		this.battery = battery;
		this.cpu = cpu;
		this.screen = screen;
		this.sensors = sensors;
	}


	public void start() {
		this.on = true;
	}
	
	public void stop() {
		this.on = false;
	}


	public Battery getBattery() {
		return battery;
	}


	public CPU getCpu() {
		return cpu;
	}


	public Screen getScreen() {
		return screen;
	}


	public List<Sensor> getSensors() {
		return sensors;
	}


	public Boolean getOn() {
		return on;
	}


	public void setBattery(Battery battery) {
		this.battery = battery;
	}


	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}


	public void setScreen(Screen screen) {
		this.screen = screen;
	}


	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}


	public void setOn(Boolean on) {
		this.on = on;
	}
	
	
	
	

}
