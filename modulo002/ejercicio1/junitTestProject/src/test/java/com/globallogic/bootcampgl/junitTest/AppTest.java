package com.globallogic.bootcampgl.junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void test() {
		assertEquals("Test", "Test");
	}
	
	@Test
	void ejer2() {
		assertEquals("First", "First");
		assertEquals("Second", "Second");
		assertNotEquals("Third", "third");
	}

	@Test
	void ejer3() {
		assertTrue(25 > 12);
		assertFalse(25 > 27);
	}
	
	@Test
	void ejer4() {
		Long index = null;
		assertNull(index);
		index = 1L;
		assertNotNull(index);
		
	}
	
	@Test
	@DisplayName("El resultado esta bien")
	void sumCorrectTest() {
		App app = new App();
		assertEquals(app.sum(3, 3), 3+3);
	}
	
	@Test
	@DisplayName("El resultado esta mal: ")
	void sumIncorectTest() {
		App app = new App();
		assertNotEquals(app.sum(3, 3), 3+4);
	}
	
}
