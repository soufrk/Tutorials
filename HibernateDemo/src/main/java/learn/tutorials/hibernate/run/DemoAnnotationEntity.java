package learn.tutorials.hibernate.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import learn.tutorials.hibernate.annotations.Manager;
import learn.tutorials.hibernate.xml.entity.enums.Designation;

public class DemoAnnotationEntity {

	public static void main(String[] args) {
		// 1. Load Configuration
		Configuration cfg = new Configuration();
		cfg.configure(DemoAnnotationEntity.class.getClassLoader().getResource("hibernate.cfg.xml"));
		// 2. Build Session Factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 3. Open a session
		Session session = sessionFactory.openSession();
		// 4. Start a transaction
		Transaction transaction = session.beginTransaction();
		Manager mgr = new Manager(123,"HBM002",Designation.TECHINAL_ARCHITECT);
		try {
			session.save(mgr);

			// 5. commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			// 6. close the session
			session.close();
			// 7. close session factory
			sessionFactory.close();
		}
	}
}
