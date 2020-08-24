package spring.coverage.example.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import spring.coverage.example.model.Example;
import spring.coverage.example.service.ExampleService;

@ExtendWith(MockitoExtension.class)
public class ExampleControllerImplTest {

	@InjectMocks
	private ExampleController exampleController;
	
	@Mock
	private ExampleService exampleService;

	@Test
	void getExampleByIdTest() {

		final Example response = this.exampleController.getExampleById(2347);
		assertThat(response).isNull();

	}
	
	@Test
	void getAllExamplesTest(){
		Mockito.when(exampleService.getAllExamples()).thenReturn(new ArrayList<>());
		
		assertTrue(exampleController.getAllExamples().isEmpty());
	}
	
	@Test
	void getAllExamplesTestShouldReturnNull(){
		Mockito.when(exampleService.getAllExamples()).thenReturn(null);
		
		assertNull(exampleController.getAllExamples());
	}
	
	@Test
	void createExampleTestShouldReturnTrueFalse(){
		Mockito.when(exampleService.createExample(Mockito.any())).thenReturn(true,false);
		
		assertTrue(exampleController.createExample(Example.builder().build()));
		assertFalse(exampleController.createExample(Example.builder().build()));
	}
	
	@Test
	void createExampleTestShouldThrownException(){
		Mockito.when(exampleService.createExample(Mockito.any())).thenThrow(RuntimeException.class);
		
		assertThrows(RuntimeException.class, () -> exampleController.createExample(Example.builder().build()));
	}
	
}
