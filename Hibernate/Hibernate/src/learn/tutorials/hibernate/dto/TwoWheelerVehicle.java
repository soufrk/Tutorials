package learn.tutorials.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/*
 * Discriminator value will be the provided one in this annotation rather than class name
 */
@DiscriminatorValue("Bike")
public class TwoWheelerVehicle extends Vehicle {
	private String steeringhandle;
	
	public String getSteeringhandle() {
		return steeringhandle;
	}

	public void setSteeringhandle(String steeringhandle) {
		this.steeringhandle = steeringhandle;
	}
}
