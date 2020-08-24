package spring.coverage.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import spring.coverage.example.model.Example;
import spring.coverage.example.service.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService {

	private static final int ID = 633452;
	private static final String NAME = "Ejemplo de Covertura";
	private static final int VALUE = 473632;

	private static final int ID_DOS = 743492;
	private static final String NAME_DOS = "Segundo Ejemplo de Covertura";
	private static final int VALUE_DOS = 2455632;

	@Override
	public Example getById(int id) {
		return Example.builder().id(ID).name(NAME).value(VALUE).build();
	}

	@Override
	public List<Example> getAllExamples() {

		List<Example> result = new ArrayList<>();
		
		Example example = Example.builder().id(ID).name(NAME).value(VALUE).build();
		result.add(example);
		Example e2 = Example.builder().id(ID_DOS).name(NAME_DOS).value(VALUE_DOS).build();
		result.add(e2);
			
		return result;
	}

	@Override
	public Boolean createExample(Example example) {
		if (example.getId() <= 0)
			throw new UnsupportedOperationException();
		
		return Boolean.TRUE;
	}

}
