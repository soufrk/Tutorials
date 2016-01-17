package learn.tutorials.hibernate.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
/*
 * We can provide different strategies for inheritance hierarchy. By default it
 * is SINGLE_TABLE, others are JOIN_TABLE, TABLE_PER_CLASS
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
 * We can change the name of Discriminator column from DTYPE to something else
 * as well as we can provide the discriminator type
 */
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleid;
	private String vehiclename;

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
}
