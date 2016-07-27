package learn.tutorials.jpa.chapter1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity class to map a table called java
 * 
 * @author KD
 *
 */
@Entity
@Table(name = "Vehicle")
public class Vehicle {

	@Id
	@Column(name = "VIN")
	private String vin;
	@Column(name = "MAKE")
	private String make;
	// @Column can be omitted if the column name is same in database
	private String model;
	@Column(name = "MODEL_YEAR")
	private int year;
	// @Version indicates that it is a version field for optimistic locking
	// where the column entry is 0/1 at the time of insert and is incremented by
	// 1 with each update
	@Version
	private int version;

	public Vehicle() {
	}

	public Vehicle(String vin, String make, String model, int year, int version) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.version = version;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", version=" + version
				+ "]";
	}

}
