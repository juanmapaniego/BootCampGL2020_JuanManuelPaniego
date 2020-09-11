package coverage.example.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StarTest {

	private static final String NAME = "SUN";
	private Star star;
	
	@BeforeEach
	void setup() {
		star = new Star();
		star.setName(NAME);
	}
	
	@Test
	@DisplayName("Testing ToString")
	void testPlanetToString() {
		assertNotNull(star.toString());
	}
	
	@Test
	@DisplayName("Testing star name")
	void testName() {
		assertEquals(NAME, star.getName());
	}
	
	@Test
	@DisplayName("Testing star color")
	void testColor() {
		assertNull(star.getColor());
	}
	
	@Test
	@DisplayName("Testing star list of planets as null")
	void testPlanets() {
		assertNull(star.getPlanets());
	}
	
	@Test
	@DisplayName("Testing star list of planets as not null")
	void testPlanetsNotNull() {
		star.setPlanets(new ArrayList<>());
		assertNotNull(star.getPlanets());
	}
	
	

}
