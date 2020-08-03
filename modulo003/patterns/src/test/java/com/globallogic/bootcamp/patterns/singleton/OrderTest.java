package com.globallogic.bootcamp.patterns.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void test() {
		Order order1 = new Order("Order 1", 0);
		Order order2 = new Order("Order 2", 10);
		
		assertNotEquals(order1, order2);
		assertEquals(order1.getCurrency(), order2.getCurrency());
	}

}
