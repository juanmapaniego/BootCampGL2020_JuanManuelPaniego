package com.globallogic.bootcamp.patterns.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	@Test
	void currencyTest() {
		Order order1 = new Order("Order 1", 0);
		Order order2 = new Order("Order 2", 10);
		
		assertNotEquals(order1, order2);
		assertSame(order1.getCurrency(), order2.getCurrency());
	}
	
	@Test
	void productTest() {
		Order order1 = new Order("Order 1", 0);
		Order order2 = new Order("Order 2", 10);
		
		assertNotEquals(order1, order2);
		assertSame(order1.getProduct(), order2.getProduct());
	}

}
