package learn.tutorials.jpa.chapter1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Basic CRUD operations using JPA (Application managed)
 * 
 * @author KD
 *
 */
public class TestClass {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("A1000", "Hyundai", "i20", 2016, 0);
		// create a vehicle
		createVehicle(v1);

		// retrieve a vehicle;
		Vehicle v2 = readvehicle("A1000");
		System.out.println(v2);

		Vehicle v3 = updateVehicle(v2);
		System.out.println(v3);

		// delete a vehicle
		deleteVehicle(v3);
	}

	/**
	 * Insert a vehicle object as row in the table
	 * 
	 * @param v1
	 *            : object to be persisted
	 */
	public static void createVehicle(Vehicle v1) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(v1);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Retrieves a vehicle row based on provided vin
	 * 
	 * @param string
	 */
	private static Vehicle readvehicle(String vin) {
		EntityManager em = emf.createEntityManager();
		Vehicle v1 = null;
		try {
			em.getTransaction().begin();
			v1 = em.find(Vehicle.class, vin);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return v1;
	}

	/**
	 * Updates a vehicle row
	 * 
	 * @param string
	 */
	private static Vehicle updateVehicle(Vehicle v1) {
		EntityManager em = emf.createEntityManager();
		Vehicle v2 = null;
		try {
			em.getTransaction().begin();
			v2 = em.merge(v1);
			v2.setModel("i10");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return v2;
	}

	/**
	 * Deletes a vehicle row
	 * 
	 * @param string
	 */
	private static Vehicle deleteVehicle(Vehicle v1) {
		EntityManager em = emf.createEntityManager();
		Vehicle v2 = null;
		try {
			em.getTransaction().begin();
			v2 = em.merge(v1);
			em.remove(v2);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return v2;
	}

}