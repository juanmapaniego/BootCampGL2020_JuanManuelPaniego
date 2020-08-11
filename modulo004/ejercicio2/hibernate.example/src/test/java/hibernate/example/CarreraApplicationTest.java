package hibernate.example;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import hibernate.example.dao.CarreraDao;
import hibernate.example.dao.CompetidorDao;
import hibernate.example.model.Carrera;
import hibernate.example.model.Competidor;
import hibernate.example.services.CarreraService;
import hibernate.example.services.CompetidorService;

class CarreraApplicationTest {

	private static CarreraService carreraService;
	private static CompetidorService competidorService;

	@BeforeAll
	static void setup() {
		Competidor seb = new Competidor(1L, 2, "Sebastian Loeb");
		Competidor mar = new Competidor(2L, 3, "Marcus Groholm");
		Competidor car = new Competidor(3L, 7, "Carlos Sainz");
		Competidor pet = new Competidor(4L, 11, "Peter Solberg");
		
		competidorService = new CompetidorService();
		competidorService.createCompetidor(seb);		
		competidorService.createCompetidor(mar);
		competidorService.createCompetidor(car);				
		competidorService.createCompetidor(pet);	
		
		carreraService = new CarreraService();

		Carrera carrera = new Carrera();
		carrera.setId(1L);
		carrera.setCompetidores(competidorService.getCompetidores());
		carrera.setFecha(
				Date.from(Instant.now())
				);
		carrera.setNombre("Gran Carrera Global");

		carreraService.createCarrera(carrera);


	}

	@Test
	void testGet() {
		assertNotNull(carreraService.getCarreras());
	}

	@Test
	void test2() {
			Carrera update = carreraService.getCarreras().get(0);

			update.setNombre("Test");

			carreraService.updateCarrera(update);


			assertEquals("Test", carreraService.getCarreras().get(0).getNombre());
	}

}
