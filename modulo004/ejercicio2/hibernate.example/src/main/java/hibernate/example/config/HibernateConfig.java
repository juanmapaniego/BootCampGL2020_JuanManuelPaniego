package hibernate.example.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import hibernate.example.model.Alumno;
import hibernate.example.model.Menu;

public class HibernateConfig {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties properties = new Properties();
				
				properties.put(Environment.DRIVER, "org.h2.Driver");
				properties.put(Environment.URL, "jdbc:h2:.");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "root");
				properties.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(properties);
				configuration.addAnnotatedClass(Alumno.class);
				configuration.addAnnotatedClass(Menu.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	


}
