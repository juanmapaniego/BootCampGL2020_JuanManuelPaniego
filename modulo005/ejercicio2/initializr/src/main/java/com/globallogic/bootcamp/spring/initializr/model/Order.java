package com.globallogic.bootcamp.spring.initializr.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
	private String product;
	private Integer count;
	private Customer customer;
}
