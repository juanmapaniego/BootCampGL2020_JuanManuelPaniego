/**
 * 
 */
package mockito.example.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.example.services.impl.CalculatorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	@Mock
	BasicOperationsService basicOperationsServiceMock;
	private CalculatorServiceImpl calculatorService;
	
	@BeforeEach
	void setup() {
		calculatorService = new CalculatorServiceImpl();
		calculatorService.setBasicOperationsService(basicOperationsServiceMock);
	}
	@Test
	void testAdd() {
		Mockito.when(basicOperationsServiceMock.add(1.0,1.0)).thenReturn(2.0);
		
		calculatorService.calculateSum(1, 1);
		verify(basicOperationsServiceMock).add(1.0, 1.0);
	}
	
	@Test
	void testSubstract() {
		Mockito.when(basicOperationsServiceMock.subtract(1.0,1.0)).thenReturn(0.0);
		
		calculatorService.calculateSubstraction(1, 1);
		verify(basicOperationsServiceMock).subtract(1.0, 1.0);
	}
	
	@Test
	void testMultiply() {
		Mockito.when(basicOperationsServiceMock.multiply(1.0,1.0)).thenReturn(1.0);
		
		calculatorService.calculateMultiplication(1, 1);
		verify(basicOperationsServiceMock).multiply(1.0, 1.0);
	}
	
	@Test
	void testDivide() {
		Mockito.when(basicOperationsServiceMock.divide(1.0,1.0)).thenReturn(1.0);
		
		calculatorService.calculateDivision(1, 1);
		verify(basicOperationsServiceMock).divide(1.0, 1.0);
	}
	
	

}
