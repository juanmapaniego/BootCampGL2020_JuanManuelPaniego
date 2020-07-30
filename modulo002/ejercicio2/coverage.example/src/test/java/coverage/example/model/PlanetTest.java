package coverage.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlanetTest {
	
	Planet planet;
	
	@BeforeEach
	void setup() {
		planet = new Planet();
	}
	
	@Test
	@DisplayName("Planet name as expected")
	void testName() {
		planet.setName("Tierra");
		assertEquals("Tierra", planet.getName());
	}
	
	@Test
	@DisplayName("Planet to string test")
	void testToString() {
		planet.setName("Tierra");
		assertEquals("Planet [name=Tierra]", planet.toString());
	}

}
