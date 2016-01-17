package learn.tutorials.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/*
 * Annotation to specify this class as an entity class
 */
@Entity
/*
 * Annotation to specify the name of this entity
 */
@Table(name = "USER_DETAILS_TABLE")
public class UserDetails {
	/*
	 * Annotation to indicate this as the primary key
	 */
	@Id
	/*
	 * Annotation to automatically generate the value of this primary key
	 */
	@GeneratedValue
	/*
	 * Annotation to specify the column name which may be different from that of
	 * the property name
	 */
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String name;

	/*
	 * Annotation to indicate to story only the date part of the timestamp
	 * rather than complete date and time
	 */
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	/*
	 * Annotation to indicate that it is a value object
	 */
	@Embedded
	/*
	 * Annotation to override the column name specified in value object
	 */
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET") ),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY") ),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE") ),
			@AttributeOverride(name = "pin", column = @Column(name = "HOME_PIN") ) })
	private Address homeAddress;

	@Embedded
	private Address officeAddress;

	/*
	 * Annotation to say that the value object is not embedded one but a
	 * different table and fetch type denotes the strategy, i.e., the way in
	 * which it will be retrieved from the database EAGER means along with the
	 * userdetails object in a single query. LAZY means whenever the getter
	 * method of this value object is called
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	/*
	 * Annotation to Indicate which table to join to
	 */
	@JoinTable(name = "USER_ADDRESS")
	/*
	 * Annotation to specify the join column of the table
	 */
	@JoinColumns({ @JoinColumn(name = "USER_ID") })
	private Set<Address> setOfAddress = new HashSet<>();

	@ElementCollection
	/*
	 * Creates a generic generator for this collection of value object
	 */
	@GenericGenerator(name = "inc-gen", strategy = "increment")
	/*
	 * Specifies the identity column of the value object using the created
	 * generic generator
	 */
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "inc-gen", type = @Type(type = "long") )
	private Collection<Address> collectionOfAddress = new ArrayList<>();

	/*
	 * One to one mapping
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	/*
	 * OneToMany mapping. cascade type defines to do the same operation on this
	 * table whatever is performed on user details table
	 */
	@OneToMany(cascade = CascadeType.ALL)
	/*
	 * Mapping table name and name of foreign key columns
	 */
	@JoinTable(name = "USER_MOBILE_MAPPING", joinColumns = @JoinColumn(name = "USER_ID") , inverseJoinColumns = @JoinColumn(name = "MOBILE_ID") )
	private List<Mobile> collectionOfMobile = new ArrayList<Mobile>();

	/*
	 * OneToMany mapping where the mapping is done in user table instead of a
	 * new mapping table. this is denoted by property mappedBy of OneToMany
	 * annotation
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Pen> collectionOfPen = new ArrayList<>();
	
	/*
	 * ManyToMany mapping
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Position> collectionOfPosition = new ArrayList<>();

	public Collection<Position> getCollectionOfPosition() {
		return collectionOfPosition;
	}

	public void setCollectionOfPosition(Collection<Position> collectionOfPosition) {
		this.collectionOfPosition = collectionOfPosition;
	}

	public List<Pen> getCollectionOfPen() {
		return collectionOfPen;
	}

	public void setCollectionOfPen(List<Pen> collectionOfPen) {
		this.collectionOfPen = collectionOfPen;
	}

	public List<Mobile> getCollectionOfMobile() {
		return collectionOfMobile;
	}

	public void setCollectionOfMobile(List<Mobile> collectionOfMobile) {
		this.collectionOfMobile = collectionOfMobile;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Collection<Address> getCollectionOfAddress() {
		return collectionOfAddress;
	}

	public void setCollectionOfAddress(Collection<Address> collectionOfAddress) {
		this.collectionOfAddress = collectionOfAddress;
	}

	public Set<Address> getSetOfAddress() {
		return setOfAddress;
	}

	public void setSetOfAddress(Set<Address> setOfAddress) {
		this.setOfAddress = setOfAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	/*
	 * Annotation to tell Hibernate that the value of this field can be a long
	 * object
	 */
	@Lob
	private String description;

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
