package learn.tutorials.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
/*
 * Changing the inheritance type to table per class
 */
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Pen {
	@Id
	@GeneratedValue
	private int penid;
	private String penName;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public int getPenid() {
		return penid;
	}

	public void setPenid(int penid) {
		this.penid = penid;
	}

	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}
}
