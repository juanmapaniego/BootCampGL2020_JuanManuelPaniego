package com.globallogic.bootcamp.patterns.delegation;

public class ElectricalOven extends ElectricalAppliance {

	private LedAppliance ledAppliance;
	
	public ElectricalOven() {
		super();
		this.ledAppliance = new LedAppliance(this);
	}
	
	@Override
	public void turnOn() {
		this.consumePower(75);
	}
	
	public void turnLed() {
		this.ledAppliance.turnOn();
	}
	

	public static void main(String[] args) {
		ElectricalOven electricalOven = new ElectricalOven();
		System.out.println(electricalOven.getPower());
		electricalOven.turnOn();
		System.out.println(electricalOven.getPower());
		electricalOven.turnLed();
		System.out.println(electricalOven.getPower());
	}
}
