package jpa.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Contains all the utility methods
public class HibernateUtil {

	//single session factory for the complete application
	private static final SessionFactory emf = new Configuration().configure().buildSessionFactory();
	
	private HibernateUtil(){
	}
	
	//method to return the same instance of sessionFactory every time.
	public static SessionFactory getSessionFactory(){
		return emf;
	}
}
