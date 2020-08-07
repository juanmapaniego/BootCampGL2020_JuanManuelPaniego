package coverage.loteria.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CartonGeneratorTest {
	@Mock
	Random randomMock;
	
	@Test
	void test() {
		CartonGenerator cartonGenerator = new CartonGenerator();
		assertNotNull(cartonGenerator.isGanador());
	}

	@Test
	void testGanador() {
		Mockito.when(randomMock.nextInt()).thenReturn(1);
		
		CartonGenerator cartonGeneratorLocal = new CartonGenerator(randomMock);
		
		assertTrue(cartonGeneratorLocal.isGanador());
	}
	
	@Test
	void testSinGanador() {
		Mockito.when(randomMock.nextInt()).thenReturn(2);
		
		CartonGenerator cartonGeneratorLocal = new CartonGenerator(randomMock);
		
		assertFalse(cartonGeneratorLocal.isGanador());
	}
}
