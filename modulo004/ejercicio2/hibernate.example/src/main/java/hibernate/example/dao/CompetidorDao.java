package hibernate.example.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.example.config.HibernateConfig;
import hibernate.example.model.Competidor;

public class CompetidorDao {
	private static CompetidorDao instance;
	
	public static CompetidorDao getInstance() {
		if(Objects.isNull(instance))
			instance = new CompetidorDao();
		return instance;
	}
	
	public boolean createCompetidor(Competidor competidor) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(competidor);
			transaction.commit();
			return true;
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Competidor> getCompetidores(){
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.createQuery("from Competidor", Competidor.class).list();
		}
	}
	
	public boolean updateCompetidor(Competidor competidor) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(competidor);
			transaction.commit();
			return true;
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
		
	public boolean removeCompetidor(Competidor competidor) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.delete(competidor);
			transaction.commit();
			return true;
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
}
