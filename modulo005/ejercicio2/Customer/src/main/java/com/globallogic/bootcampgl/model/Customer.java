package com.globallogic.bootcampgl.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
	private String name;
	private String dni;
	private Long id;
}
