package learn.tutorials.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class FountainPen extends Pen {
	private String pentype;

	public String getPentype() {
		return pentype;
	}

	public void setPentype(String pentype) {
		this.pentype = pentype;
	}
}
