package hibernate.example.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.example.config.HibernateConfig;
import hibernate.example.dao.CompetidorDao;
import hibernate.example.model.Competidor;

public class CompetidorService {
	private CompetidorDao competidorDao;
	
	public CompetidorService() {
		competidorDao = CompetidorDao.getInstance();
	}
	
	public boolean createCompetidor(Competidor competidor) {
		return this.competidorDao.createCompetidor(competidor);
	}
	
	public List<Competidor> getCompetidores(){
		return this.competidorDao.getCompetidores();
	}
	
	public boolean updateCompetidor(Competidor competidor) {
		return this.competidorDao.updateCompetidor(competidor);
	}
		
	public boolean removeCompetidor(Competidor competidor) {
		return this.competidorDao.removeCompetidor(competidor);
	}
}
