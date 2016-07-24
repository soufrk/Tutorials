package learn.tutorials.hibernate.annotations.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import learn.tutorials.hibernate.annotations.FunctionalCreationTimestamp;

@Entity(name = "value_generation")
public class HibernateValueGeneration {
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "timestamp")
	@FunctionalCreationTimestamp
	private Date timestamp;

	public HibernateValueGeneration() {
	}

	public HibernateValueGeneration(int id, Date timestamp) {
		this.id = id;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
