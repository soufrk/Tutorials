package learn.tutorials.hibernate.annotations.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "quoted_identifier")
public class QuotedIdentifierEntity {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "`quoted_name`")
	private String quotedName;

	public QuotedIdentifierEntity() {
	}

	public QuotedIdentifierEntity(String quotedName) {
		this.quotedName = quotedName;
	}

	public String getQuotedName() {
		return quotedName;
	}

	public void setQuotedName(String quotedName) {
		this.quotedName = quotedName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
