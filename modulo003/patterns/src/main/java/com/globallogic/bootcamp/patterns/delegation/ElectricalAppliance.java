package com.globallogic.bootcamp.patterns.delegation;

public class ElectricalAppliance {
	private Integer power;
	
	public ElectricalAppliance() {
		power = 500;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}
	
	public void turnOn() {
		this.power -= 50;
	}
	
	public void consumePower(int consume) {
		this.power -= consume;
	}
	
}
