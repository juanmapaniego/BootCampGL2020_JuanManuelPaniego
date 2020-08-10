package hibernate.example.services;

import java.util.List;

import hibernate.example.dao.AlumnoDao;
import hibernate.example.model.Alumno;

public class AlumnoService {
	private AlumnoDao alumnoDao;
	
	public AlumnoService() {
		alumnoDao = AlumnoDao.getInstance();
	}
	
	public void createAlumno(Alumno alumno) {
		this.alumnoDao.createAlumno(alumno);
	}
	
	public List<Alumno> getAlumnos() {
		return this.alumnoDao.getAlumnos();
	}
	
	public List<Alumno> getAlumnos(String nombre, String apellido){
		return this.alumnoDao.getAlumnos(nombre, apellido);
	}
	
	public void updateAlumno(Alumno alumno) {
		this.alumnoDao.updateAlumno(alumno);
	}
	
	public void removeAlumno(Alumno alumno) {
		this.alumnoDao.removeAlumno(alumno);
	}
}
