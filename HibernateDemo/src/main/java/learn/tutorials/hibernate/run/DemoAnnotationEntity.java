package learn.tutorials.hibernate.run;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import learn.tutorials.hibernate.annotations.entity.HibernateValueGeneration;
import learn.tutorials.hibernate.annotations.entity.QuotedIdentifierEntity;
import learn.tutorials.hibernate.utility.HibernateUtil;

public class DemoAnnotationEntity {

	public static void main(String[] args) {
		// 1. Get session Factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// 2. Open session
		Session session = sessionFactory.openSession();
		// 3. Start a transaction
		Transaction transaction = session.beginTransaction();

		// Test manager entity
		// Manager mgr = new Manager(12, "HBM002",
		// Designation.TECHINAL_ARCHITECT, Gender.MALE,
		// "QAZWSXEDCRFVTGBYHNUJM34567893456789");

		// Test Date Event Entity
		// DateEvent dateEvent = new DateEvent(new Date(), new Date(), new
		// Date());

		// Test Quoted Identifier Entity
		// QuotedIdentifierEntity identifierEntity = new
		// QuotedIdentifierEntity("Saurabh Kedia");

		// Test hibernate value generator
		HibernateValueGeneration hibernateValueGeneration = new HibernateValueGeneration();

		try {
			// 4. Save the session
			// session.save(mgr);
			// session.save(dateEvent);
			// session.save(identifierEntity);
			session.save(hibernateValueGeneration);

			// 5. commit the transaction
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			// 6. close the session
			session.close();
			// 7. close session factory
			HibernateUtil.getSessionFactory().close();
		}
	}
}
