package com.globallogic.bootcamp.patterns.delegation;

public class LedAppliance {
	private ElectricalAppliance electricalAppliance;
	
	public LedAppliance(ElectricalAppliance electricalAppliance) {
		this.electricalAppliance = electricalAppliance;
	}
	
	public void turnOn() {
		this.electricalAppliance.consumePower(100);
	}
	
}
