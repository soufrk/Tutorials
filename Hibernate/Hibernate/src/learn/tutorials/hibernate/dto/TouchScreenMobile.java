package learn.tutorials.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class TouchScreenMobile extends Mobile {
	private String touchScreenMake;

	public String getTouchScreenMake() {
		return touchScreenMake;
	}

	public void setTouchScreenMake(String touchScreenMake) {
		this.touchScreenMake = touchScreenMake;
	}

}
