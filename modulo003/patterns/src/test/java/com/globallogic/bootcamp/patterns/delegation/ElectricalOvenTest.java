package com.globallogic.bootcamp.patterns.delegation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectricalOvenTest {
	private ElectricalOven electricalOven;
	
	@BeforeEach
	void setup() {
		electricalOven = new ElectricalOven();
	}
	
	@Test
	void testTurnOn() {
		electricalOven.turnOn();
		assertEquals(425, electricalOven.getPower());
	}

	@Test
	void testElectricalOven() {
		assertNotNull(electricalOven);
		assertEquals(500, electricalOven.getPower());
	}

	@Test
	void testTurnLed() {
		electricalOven.turnLed();
		assertEquals(400, electricalOven.getPower());
	}

}
