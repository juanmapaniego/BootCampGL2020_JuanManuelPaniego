package coverage.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GalaxyTest {

	@Test
	@DisplayName("Galaxy name as expected")
	void testName() {
		Galaxy galaxy = new Galaxy("via lactea");
		assertEquals("via lactea", galaxy.name);
	}
	
	@Test
	@DisplayName("Stars list not null")
	void testStars() {
		Galaxy galaxy = new Galaxy("via lactea");
		assertNotNull(galaxy.stars);
	}


}
