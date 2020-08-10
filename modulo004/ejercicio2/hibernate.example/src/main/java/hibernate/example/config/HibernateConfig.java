package hibernate.example.config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;
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
				String propFileName = "db.properties";
				
				InputStream inputStream = HibernateConfig.class.getClassLoader().
						getResourceAsStream(propFileName);
				
				Configuration configuration = new Configuration();
				Properties properties = new Properties();
				
				if(!Objects.isNull(inputStream)) {
					properties.load(inputStream);
				}else {
					throw new FileNotFoundException();
				}								
				
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
