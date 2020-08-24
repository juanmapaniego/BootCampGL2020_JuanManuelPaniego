package com.globallogic.bootcampgl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.bootcampgl.model.Order;

@Component
public class OrderFactory {

	
	public Order getNewOrder() {
		return Order.builder()
				.product("C-00221")
				.count(1000)
				.customer(12342L)
				.build();
	}
}
