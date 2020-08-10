package hibernate.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.example.config.HibernateConfig;
import hibernate.example.model.Alumno;
import hibernate.example.model.Menu;

public class MenuDao {
	
	public void createMenu(Menu menu) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(menu);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Menu> getMenues(){
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.createQuery("from Menu", Menu.class).list();
		}
	}
	
	public Menu getMenu(Long id){
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.createQuery("from Menu m where m.id = :id", Menu.class)
					.setParameter("id", id).getSingleResult();
		}
	}
	
	public void updateMenu(Menu menu) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(menu);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
		
	public void removeMenu(Menu menu) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.delete(menu);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
