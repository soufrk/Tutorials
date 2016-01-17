package learn.tutorials.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class BallPen extends Pen {
	private String pentype;

	public String getPentype() {
		return pentype;
	}

	public void setPentype(String pentype) {
		this.pentype = pentype;
	}
}
