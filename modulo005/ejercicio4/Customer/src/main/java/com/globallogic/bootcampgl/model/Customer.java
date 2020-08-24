package com.globallogic.bootcampgl.model;

import org.springframework.beans.factory.annotation.Value;
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
	@Value("${in.name}")
	private String name;
	@Value("${in.dni}")
	private String dni;
	@Value("${in.id}")
	private Long id;
}
