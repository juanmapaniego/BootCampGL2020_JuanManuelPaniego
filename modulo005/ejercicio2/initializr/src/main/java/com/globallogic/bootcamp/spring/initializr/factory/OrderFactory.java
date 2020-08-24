package com.globallogic.bootcamp.spring.initializr.factory;

import org.springframework.stereotype.Component;

import com.globallogic.bootcamp.spring.initializr.model.Customer;
import com.globallogic.bootcamp.spring.initializr.model.Order;

@Component
public class OrderFactory {
	public Order getNewOrder() {
		return Order.builder()
				.product("C-00221")
				.count(1000)
				.customer(
						Customer.builder()
						.name("Jose Perez")
						.dni("234567890")
						.id(12342L)
						.build()
				).build();
	}
}
