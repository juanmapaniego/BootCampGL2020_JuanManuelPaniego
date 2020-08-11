package hibernate.example.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.example.config.HibernateConfig;
import hibernate.example.model.Carrera;

public class CarreraDao {
	private static CarreraDao instance;
	
	public static CarreraDao getInstance() {
		if(Objects.isNull(instance))
			instance = new CarreraDao();
		return instance;
	}
	
	public boolean createCarrera(Carrera carrera) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(carrera);
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
	
	public List<Carrera> getCarreras(){
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.createQuery("from Carrera", Carrera.class).list();
		}
	}
	
	public Carrera getCarrera(Long id){
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.createQuery("from Carrera where id = :id", Carrera.class)
					.setParameter("id", id).uniqueResult();
		}
	}
	
	public boolean updateCarrera(Carrera carrera) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(carrera);
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
		
	public boolean removeCarrera(Carrera carrera) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.delete(carrera);
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
