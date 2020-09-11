package mockito.example.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import mockito.example.services.BasicOperationsService;

class BasicOperationsServiceImplTest {

	private BasicOperationsService basicOperationsService;
	
	@BeforeEach
	void setup() {
		basicOperationsService = new BasicOperationsServiceImpl();
	}
	
	@ParameterizedTest
	@CsvSource({"1.0,1.0","2.0,2.0"})
	void testAdd(double input1, double input2) {
		assertEquals(input1+input2, basicOperationsService.add(input1, input2));
	}

	@ParameterizedTest
	@CsvSource({"1.0,1.0","2.0,2.0"})
	void testSubtract(double input1, double input2) {
		assertEquals(input1-input2, basicOperationsService.subtract(input1, input2));
	}

	@ParameterizedTest
	@CsvSource({"1.0,1.0","2.0,2.0"})
	void testMultiply(double input1, double input2) {
		assertEquals(input1*input2, basicOperationsService.multiply(input1, input2));
	}

	@ParameterizedTest
	@CsvSource({"1.0,1.0","2.0,2.0"})
	void testDivide(double input1, double input2) {
		assertEquals(input1/input2, basicOperationsService.divide(input1, input2));
	}

}
