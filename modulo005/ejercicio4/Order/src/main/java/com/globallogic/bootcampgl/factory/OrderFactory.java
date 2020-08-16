package com.globallogic.bootcampgl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.globallogic.bootcampgl.model.Order;

@Component
public class OrderFactory {
	
	@Value("${in.product}")
	private String product;
	@Value("${in.count}")
	private Integer count;
	@Value("${in.customer}")
	private long customer;
	
	public Order getNewOrder() {
		return Order.builder()
				.product(product)
				.count(count)
				.customer(customer)
				.build();
	}
}
