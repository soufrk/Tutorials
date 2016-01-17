package learn.tutorials.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Position {

	@Id
	@GeneratedValue
	private int positionid;
	private String positionname;
	@ManyToMany(mappedBy="collectionOfPosition")
	private Collection<UserDetails> userCollection = new ArrayList<>();

	public Collection<UserDetails> getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(Collection<UserDetails> userCollection) {
		this.userCollection = userCollection;
	}

	public int getPositionid() {
		return positionid;
	}

	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
}
