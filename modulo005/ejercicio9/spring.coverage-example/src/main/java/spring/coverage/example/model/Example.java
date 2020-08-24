package spring.coverage.example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Example {

	private int id;
	private String name;
	private int value;
}
