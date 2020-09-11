package coverage.loteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coverage.loteria.model.CartonGenerator;

class LoteriaTest {
	private static final float  POZO = 10.0f;
	private static final int BOLETOS = 2;
	private Loteria loteria;
	
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

}
