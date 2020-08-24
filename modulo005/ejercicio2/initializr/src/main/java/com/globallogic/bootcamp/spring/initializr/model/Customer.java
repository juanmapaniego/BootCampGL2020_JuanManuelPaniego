package com.globallogic.bootcamp.spring.initializr.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
	private String name;
	private String dni;
	private Long id;
}
