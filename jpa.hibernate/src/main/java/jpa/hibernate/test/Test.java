package jpa.hibernate.test;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.CriterionEntry;

import jpa.hibernate.bdo.Employee;
import jpa.hibernate.util.Entity;

public final class Test {

	public static void main(String[] args) {
		// Test CRUD operations using the generic DAO
		/*
		Employee emp = new Employee();
		emp.setName("Souvik");
		Entity<Employee> entity = new Entity<>(Employee.class);
		Serializable id = entity.createRow(emp);
		long primaryKey = 0;
		if(id instanceof Long)
			primaryKey = (long)id;
		
		System.out.println(entity.readRow(primaryKey));
		
		Employee updateEmp = new Employee();
		updateEmp.setId(primaryKey);
		updateEmp.setName("Souvik Goswami");
		entity.updateRow(updateEmp);
		
		Employee empRead = entity.readRow(primaryKey);
		System.out.println(empRead);
		
		entity.deleteRow(empRead);
		
		System.out.println(entity.readRow(primaryKey));
	*/
	
		// Test find All
		Entity<Employee> entity = new Entity<>(Employee.class);
		System.out.println(entity.getAll());
		System.out.println(entity.getSingleResult(Restrictions.ilike("name", "Saurabh",MatchMode.ANYWHERE)));
		
	}

}
