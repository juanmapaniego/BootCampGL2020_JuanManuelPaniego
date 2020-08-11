package hibernate.example;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hibernate.example.model.Carrera;
import hibernate.example.model.Competidor;
import hibernate.example.services.CarreraService;
import hibernate.example.services.CompetidorService;

public class CarreraApplication {

	public static void main(String[] args) {
		Competidor seb = new Competidor(1L, 2, "Sebastian Loeb");
		Competidor mar = new Competidor(2L, 3, "Marcus Groholm");
		Competidor car = new Competidor(3L, 7, "Carlos Sainz");
		Competidor pet = new Competidor(4L, 11, "Peter Solberg");
		
		CompetidorService competidorService = new CompetidorService();
		competidorService.createCompetidor(seb);		
		competidorService.createCompetidor(mar);
		competidorService.createCompetidor(car);				
		competidorService.createCompetidor(pet);		
		System.out.println(competidorService.getCompetidores());
		
		CarreraService carreraService = new CarreraService();
		
		/*List<Competidor> competidores = new ArrayList<>();
		competidores.add(seb);
		competidores.add(mar);
		competidores.add(car);
		competidores.add(pet);*/
		
		
		Carrera carrera = new Carrera();
		carrera.setId(1L);
		carrera.setCompetidores(competidorService.getCompetidores());
		carrera.setFecha(
				Date.from(Instant.now())
				);
		carrera.setNombre("Gran Carrera Global");
		
		carreraService.createCarrera(carrera);		
		
		System.out.println(carreraService.getCarreras());
		System.out.println(carreraService.getCarrera(2l));
	}

}
