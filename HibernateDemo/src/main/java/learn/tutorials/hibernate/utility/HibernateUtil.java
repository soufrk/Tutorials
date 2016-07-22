package learn.tutorials.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure(HibernateUtil.class.getClassLoader().getResource("hibernate.cfg.xml"))
					.buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
