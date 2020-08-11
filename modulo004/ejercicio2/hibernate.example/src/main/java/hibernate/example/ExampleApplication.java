package hibernate.example;

import hibernate.example.dao.AlumnoDao;
import hibernate.example.model.Alumno;
import hibernate.example.services.AlumnoService;

public class ExampleApplication {

	public static void main(String[] args) {
		Alumno alumnoPerez = new Alumno(1L,"Jose","Perez");
		
		Alumno alumnoQuito = new Alumno(2L,"Esteban","Quito");	
		
		Alumno alumnoGodofreda = new Alumno(3L,"Ulrica","Godofreda");
		
		AlumnoService  alumnoService = new AlumnoService();
		
		// Creates alumnos
		alumnoService.createAlumno(alumnoPerez);
		alumnoService.createAlumno(alumnoQuito);
		alumnoService.createAlumno(alumnoGodofreda);
		
		// Prints all
		System.out.println(alumnoService.getAlumnos());
		
		//Modify Quito
		alumnoQuito.setNombre("Estefano");
		alumnoService.updateAlumno(alumnoQuito);
				
		// Prints all
		System.out.println(alumnoService.getAlumnos());
		
		// Print Perez
		System.out.println(alumnoService.getAlumnos("Jose","Perez"));
		
		// Remove Perez
		alumnoService.removeAlumno(alumnoPerez);
		
		// Prints all
		System.out.println(alumnoService.getAlumnos());

	}

}
