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
		assertEquals("First", "First");
		assertEquals("Second", "Second");
		assertNotEquals("Third", "third");
	}

}
