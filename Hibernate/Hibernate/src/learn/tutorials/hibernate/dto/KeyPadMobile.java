package learn.tutorials.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class KeyPadMobile extends Mobile {
	private String noOfKeys;

	public String getNoOfKeys() {
		return noOfKeys;
	}

	public void setNoOfKeys(String noOfKeys) {
		this.noOfKeys = noOfKeys;
	}
}
