package learn.tutorials.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheelerVehicle extends Vehicle {

	private String steeringwheel;

	public String getSteeringwheel() {
		return steeringwheel;
	}

	public void setSteeringwheel(String steeringwheel) {
		this.steeringwheel = steeringwheel;
	}
}
