package learn.tutorials.hibernate.xml.entity;

import java.io.Serializable;

import learn.tutorials.hibernate.xml.entity.enums.Designation;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String empId;
	private String firstName;
	private String lastName;
	private Designation designation;

	public Employee() {
	}

	public Employee(String empId, String firstName, String lastName, Designation designation) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}
