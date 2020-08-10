package hibernate.example;

import hibernate.example.dao.AlumnoDao;
import hibernate.example.model.Alumno;

public class ExampleApplication {

	public static void main(String[] args) {
		Alumno alumnoPerez = new Alumno();
		alumnoPerez.setId(1l);
		alumnoPerez.setApellido("Perez");
		alumnoPerez.setNombre("Jose");
		
		Alumno alumnoQuito = new Alumno();
		alumnoQuito.setId(2l);
		alumnoQuito.setApellido("Quito");
		alumnoQuito.setNombre("Esteban");
		
		Alumno alumnoGodofreda = new Alumno();
		alumnoGodofreda.setId(3l);
		alumnoGodofreda.setApellido("Godofreda");
		alumnoGodofreda.setNombre("Ulrica");
		
		AlumnoDao alumnoDao = new AlumnoDao();
		
		// Creates alumnos
		alumnoDao.createAlumno(alumnoPerez);
		alumnoDao.createAlumno(alumnoQuito);
		alumnoDao.createAlumno(alumnoGodofreda);
		
		// Prints all
		System.out.println(alumnoDao.getAlumnos());
		
		//Modify Quito
		alumnoQuito.setNombre("Estefano");
		alumnoDao.updateAlumno(alumnoQuito);
				
		// Prints all
		System.out.println(alumnoDao.getAlumnos());
		
		// Print Perez
		System.out.println(alumnoDao.getAlumnos("Jose","Perez"));
		
		// Remove Perez
		alumnoDao.removeAlumno(alumnoPerez);
		
		// Prints all
		System.out.println(alumnoDao.getAlumnos());

	}

}
