package coverage.loteria.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartonGeneratorTest {

	@Test
	void test() {
		CartonGenerator cartonGenerator = new CartonGenerator();
		assertNotNull(cartonGenerator.isGanador());
	}

}
