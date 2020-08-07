package coverage.loteria.model;

import java.util.Random;

public class CartonGenerator{
	
	private Random rand;
	
	public CartonGenerator()
	{
		rand = new Random();
	}
	
	public CartonGenerator(Random random)
	{
		rand = random;
	}
	
	public boolean isGanador() {
		return rand.nextInt() == 1;
	}	
}
