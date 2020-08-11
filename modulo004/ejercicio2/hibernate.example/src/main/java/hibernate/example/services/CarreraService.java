package hibernate.example.services;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.example.config.HibernateConfig;
import hibernate.example.dao.CarreraDao;
import hibernate.example.model.Carrera;

public class CarreraService {
	private CarreraDao carreraDao;
	
	public CarreraService() {
		carreraDao = CarreraDao.getInstance();
	}
	
	public boolean createCarrera(Carrera carrera) {
		return this.carreraDao.createCarrera(carrera);
	}
	
	public List<Carrera> getCarreras(){
		return this.carreraDao.getCarreras();
	}
	
	public Carrera getCarrera(Long id){		
		Carrera res = this.carreraDao.getCarrera(id);
		if(Objects.isNull(res))
			throw new IllegalArgumentException();
		return res;
	}
	
	public boolean updateCarrera(Carrera carrera) {
		return this.carreraDao.updateCarrera(carrera);
	}
		
	public boolean removeCarrera(Carrera carrera) {
		return this.carreraDao.removeCarrera(carrera);
	}
}
