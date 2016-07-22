package learn.tutorials.hibernate.annotations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import learn.tutorials.hibernate.xml.entity.enums.Designation;
import learn.tutorials.hibernate.xml.entity.enums.converter.GenderConverter;

@Entity
@Table(name = "manager")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name = "manager_id")
	private String empId;
	@Enumerated(EnumType.STRING)
	@Column(name = "designation")
	@Convert(converter = GenderConverter.class)
	private Designation designation;

	public Manager() {
	}

	public Manager(int id, String empId, Designation designation) {
		this.id = id;
		this.empId = empId;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}
