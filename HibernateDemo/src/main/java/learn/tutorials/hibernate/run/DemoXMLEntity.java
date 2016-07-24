package learn.tutorials.hibernate.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import learn.tutorials.hibernate.xml.entity.Employee;
import learn.tutorials.hibernate.xml.entity.enums.Designation;

public class DemoXMLEntity {

	public static void main(String[] args) {
		// 1. Load Configuration
		Configuration cfg = new Configuration();
		cfg.configure(DemoXMLEntity.class.getClassLoader().getResource("hibernate.cfg.xml"));
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			// 2. Build Session Factory
			sessionFactory = cfg.buildSessionFactory();
			// 3. Open a session
			session = sessionFactory.openSession();
			// 4. Start a transaction
			transaction = session.beginTransaction();
			Employee emp = new Employee("HBM001", "Bruce", "Wayne", Designation.SOFTWARE_ENGINEER, null);
			emp.setId(2);
			session.save(emp);
			// 5. commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			// 6. close the session
			if (session != null)
				session.close();
			else
				System.out.println("Session is null");
			// 7. close session factory
			if (sessionFactory != null)
				sessionFactory.close();
			else
				System.out.println("SessionFactory is null");
		}
	}
}
