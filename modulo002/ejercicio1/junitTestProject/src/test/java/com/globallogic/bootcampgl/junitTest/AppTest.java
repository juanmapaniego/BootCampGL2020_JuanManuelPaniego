package com.globallogic.bootcampgl.junitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void test() {
		assertEquals("Test", "Test");
	}
	
	@Test
	void ejer2() {
		assertNotEquals("First", "First");
		assertNotEquals("Second", "Second");
		assertEquals("Third", "third");
	}

	@Test
	void ejer3() {
		assertFalse(25 > 12);
		assertTrue(25 > 27);
	}
	
	@Test
	void ejer4() {
		Long index = null;
		assertNotNull(index);
		index = 1L;
		assertNull(index);
		
	}
}
