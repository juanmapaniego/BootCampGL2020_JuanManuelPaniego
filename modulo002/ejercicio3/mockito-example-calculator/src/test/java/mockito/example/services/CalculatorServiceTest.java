/**
 * 
 */
package mockito.example.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.example.exceptions.ZeroDivisionException;
import mockito.example.services.impl.CalculatorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	@Mock
	BasicOperationsService basicOperationsServiceMock;
	@Mock
	DataService dataServiceMock;
	private CalculatorServiceImpl calculatorService;
	
	
	@BeforeEach
	void setup() {
		calculatorService = new CalculatorServiceImpl();
		calculatorService.setBasicOperationsService(basicOperationsServiceMock);
		calculatorService.setDataService(dataServiceMock);
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
	
	@Test
	@DisplayName("DataServiceMock return 3")
	void testDisplayList(){
		Mockito.when(dataServiceMock.getListOfNumbers()).thenReturn(new int[] {1,2,3,4,5});
		
		assertEquals(3.0, calculatorService.calculateAverage());
	}
	
	@Test
	@DisplayName("DataServiceMock throw")
	void testDisplayListNull(){
		Mockito.when(dataServiceMock.getListOfNumbers()).thenReturn(null);
		
		assertThrows(NullPointerException.class, () -> calculatorService.calculateAverage());
	}
	
	@Test
	@DisplayName("Zero division exception")
	void testDivideByZero(){
		assertThrows(ZeroDivisionException.class, () -> calculatorService.calculateDivision(1, 0));
		verify(basicOperationsServiceMock, never()).divide(1, 0);
	}
	
	@Test	
	void testPrintResult(){
		Mockito.when(basicOperationsServiceMock.add(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(5.0);
		String expected = "El resultado es: 5.0";
		String actual = calculatorService.printResult(calculatorService.calculateSum(Mockito.anyInt(), Mockito.anyInt()));
		
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,3,5,7})
	void testIsOdd(int a) {
		assertTrue(calculatorService.isOdd(a));
	}
	

}
