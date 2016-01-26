package jpa.hibernate.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Criterion;

/**
 * Generic class for any entity and methods for basic CRUD operations on them
 * @author KD
 *
 * @param <T>
 */
public class Entity<T> {

	private static final Log log = LoggerFactory.make(Entity.class.getName());
	private Class<T> clazz;
	
	public Entity(Class<T> clazz){
		this.clazz = clazz;
	}
	
	//Insert a new row in the table specified
	public Serializable createRow(T t) {
		Serializable primaryKey = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			primaryKey = session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().markRollbackOnly();
			throw e;
		}
		return primaryKey;
	}
	
	//Read a row from the specified table using given primaryKey
	public T readRow(Serializable primaryKey){
		Session session = null;
		T t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			t = session.get(clazz, primaryKey);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().markRollbackOnly();
			throw e;
		}
		return t;
	
	}

	//Update a row having same primary key of the object passed
	public void updateRow(T t) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().markRollbackOnly();
			throw e;
		}
	}
	
	//Delete a row matching the given instance from the table specified
	public void deleteRow(T t){
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().markRollbackOnly();
			throw e;
		}
	}
	
	//Get All rows of the table specified
	public List<T> getAll(){
		Session session = null;
		List<T> resultList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			resultList = session.createCriteria(clazz).setResultTransformer(Criteria.PROJECTION).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().markRollbackOnly();
			throw e;
		}
		return resultList;
	}
	
	public T getSingleResult(Criterion criterion){
		Session session = null;
		T result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(clazz);
			criteria.add(criterion);
			result = (T) criteria.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error(e);
			session.getTransaction().markRollbackOnly();
			throw e;
		}
		return result;
	}
}
