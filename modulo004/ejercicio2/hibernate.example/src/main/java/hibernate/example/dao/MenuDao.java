package hibernate.example.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.example.config.HibernateConfig;
import hibernate.example.model.Menu;

public class MenuDao {
	
	private static MenuDao instance;
	
	public static MenuDao getInstance() {
		if(Objects.isNull(instance))
			instance = new MenuDao();
		return instance;
	}
	
	public boolean createMenu(Menu menu) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(menu);
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
	
	public boolean updateMenu(Menu menu) {
		Transaction transaction = null;
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(menu);
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
