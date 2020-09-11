package coverage.loteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import coverage.loteria.model.CartonGenerator;

@ExtendWith(MockitoExtension.class)
class LoteriaTest {
	private static final float  POZO = 10.0f;
	private static final int BOLETOS = 2;
	private Loteria loteria;
	
	@Mock
	Loteria loteriaMock;
	@Mock
	CartonGenerator cartonGeneratorMock;
	
	@BeforeEach
	void setup() {
		loteria = new Loteria(POZO, BOLETOS, new CartonGenerator());
	}
	
	@Test
	void testPozos() {
		assertEquals(POZO, loteria.getPozo());
	}
	
	@Test
	void testBoletos() {
		assertEquals(BOLETOS, loteria.getBoletos());
	}
	
	@Test
	void testCeroGanadores() {
		assertEquals(0, loteria.getGanadores());
	}
	
	@Test
	void testJugada() {
		loteria.jugada();
		assertNotNull(loteria.hayGanadorUnico());
		assertNotNull(loteria.hayCuadrupleGanador());
	}
	
	@Test
	void testGanadorUnico() {
		
		Mockito.when(cartonGeneratorMock.isGanador()).thenReturn(true);
		Loteria loteriaLocal = new Loteria(POZO,1,cartonGeneratorMock);
		loteriaLocal.jugada();
		
		assertTrue(loteriaLocal.hayGanadorUnico());
	}
	
	@Test
	void testCuadrupleGanador() {
		
		Mockito.when(cartonGeneratorMock.isGanador()).thenReturn(true);
		Loteria loteriaLocal = new Loteria(POZO,4,cartonGeneratorMock);
		loteriaLocal.jugada();
		
		assertTrue(loteriaLocal.hayCuadrupleGanador());
	}

}
