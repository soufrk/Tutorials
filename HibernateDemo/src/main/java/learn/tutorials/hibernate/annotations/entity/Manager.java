package learn.tutorials.hibernate.annotations.entity;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import learn.tutorials.hibernate.xml.entity.enums.Designation;
import learn.tutorials.hibernate.xml.entity.enums.Gender;
import learn.tutorials.hibernate.xml.entity.enums.converter.GenderConverter;

@Entity
@Table(name = "manager")
public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;
	// mapping primary key
	@Id
	private int id;
	// mapping column
	@Column(name = "manager_id")
	private String empId;
	// mapping enums
	@Enumerated(EnumType.STRING)
	@Column(name = "designation")
	private Designation designation;
	// mapping enums with converter
	@Column(name = "gender")
	@Convert(converter = GenderConverter.class)
	private Gender gender;
	// mapping LOBs (Large Data Objects)
	// java.sql.Blob, java.sql.Clob, java.sql.NClob
	@Lob
	private String registraionNo;

	public Manager() {
	}

	public Manager(int id, String empId, Designation designation, Gender gender, String registrationNo) {
		this.id = id;
		this.empId = empId;
		this.designation = designation;
		this.gender = gender;
		this.registraionNo = registrationNo;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getRegistraionNo() {
		return registraionNo;
	}

	public void setRegistraionNo(String registraionNo) {
		this.registraionNo = registraionNo;
	}
}
