package learn.tutorials.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.tutorials.hibernate.dto.Address;
import learn.tutorials.hibernate.dto.BallPen;
import learn.tutorials.hibernate.dto.FountainPen;
import learn.tutorials.hibernate.dto.FourWheelerVehicle;
import learn.tutorials.hibernate.dto.KeyPadMobile;
import learn.tutorials.hibernate.dto.Mobile;
import learn.tutorials.hibernate.dto.Pen;
import learn.tutorials.hibernate.dto.Position;
import learn.tutorials.hibernate.dto.TouchScreenMobile;
import learn.tutorials.hibernate.dto.TwoWheelerVehicle;
import learn.tutorials.hibernate.dto.UserDetails;
import learn.tutorials.hibernate.dto.Vehicle;

/**
 * Test the project with a main method
 * 
 * @author KD
 *
 */
public class TestHibernateProgram {

	public static void main(String[] args) {
		// Create a usersdetails object
		UserDetails user = new UserDetails();
		user.setName("First User");

		// create address object
		Address homeAddress = new Address();
		homeAddress.setCity("homecity");
		homeAddress.setPin("homepin");
		homeAddress.setState("homestate");
		homeAddress.setStreet("homestreet");

		// create address object
		Address officeAddress = new Address();
		officeAddress.setCity("officecity");
		officeAddress.setPin("officepin");
		officeAddress.setState("officestate");
		officeAddress.setStreet("officestreet");

		// add address to user
		user.getSetOfAddress().add(homeAddress);
		user.getSetOfAddress().add(officeAddress);
		user.setJoinedDate(new Date());
		user.setDescription("First User's Description");

		// embedded value object
		user.setOfficeAddress(officeAddress);
		user.setHomeAddress(homeAddress);
		// value object in a separate table
		user.getCollectionOfAddress().add(homeAddress);
		user.getCollectionOfAddress().add(officeAddress);

		// Create Vehicle object
		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclename("car");

		// set the vehicle to user
		user.setVehicle(vehicle);

		Mobile mobile1 = new Mobile();
		mobile1.setMobilename("samsung");

		Mobile mobile2 = new Mobile();
		mobile2.setMobilename("Nokia");

		user.getCollectionOfMobile().add(mobile1);
		user.getCollectionOfMobile().add(mobile2);
		mobile1.setUserDetails(user);
		mobile2.setUserDetails(user);

		Pen pen1 = new Pen();
		pen1.setPenName("Reynolds");
		Pen pen2 = new Pen();
		pen2.setPenName("Parker");

		user.getCollectionOfPen().add(pen1);
		user.getCollectionOfPen().add(pen2);
		pen1.setUser(user);
		pen2.setUser(user);

		Position pos1 = new Position();
		pos1.setPositionname("VP");
		Position pos2 = new Position();
		pos2.setPositionname("DIRECTOR");

		UserDetails user2 = new UserDetails();
		user2.setName("User 2");

		user.getCollectionOfPosition().add(pos1);
		user.getCollectionOfPosition().add(pos2);
		pos1.getUserCollection().add(user);
		pos1.getUserCollection().add(user2);
		pos2.getUserCollection().add(user);
		pos2.getUserCollection().add(user2);

		// Testing Inheritance .. Hibernate will create a new column DTYPE in
		// Parent table where it will store the class name instead of creating
		// different tables as per the default strategy type SINGLE_TABLE
		TwoWheelerVehicle bike = new TwoWheelerVehicle();
		bike.setVehiclename("YAMAHA FZ");
		bike.setSteeringhandle("BIKE STEERING HANDLE");

		FourWheelerVehicle car = new FourWheelerVehicle();
		car.setVehiclename("RENAULT DUSTER");
		car.setSteeringwheel("CAR STEERING WHEEL");

		//Testing inheritance with table per class strategy
		BallPen ballPen = new BallPen();
		ballPen.setPenName("Ball Pen Name");
		ballPen.setPentype("BallPen");
		ballPen.setUser(user);
		
		FountainPen fountainPen = new FountainPen();
		fountainPen.setPenName("Fountain Pen Name");
		fountainPen.setPentype("Fountain Pen");
		fountainPen.setUser(user);
		
		//Testing inheritance with join table strategy
		KeyPadMobile keyPadMobile = new KeyPadMobile();
		keyPadMobile.setMobilename("NOKIA 1100");
		keyPadMobile.setNoOfKeys("20");
		keyPadMobile.setUserDetails(user);
		
		TouchScreenMobile touchScreenMobile = new TouchScreenMobile();
		touchScreenMobile.setMobilename("Sony Xperia Z");
		touchScreenMobile.setTouchScreenMake("Gorilla Glass");
		touchScreenMobile.setUserDetails(user);
		
		
		// Steps to communicate with Database
		// Step 1
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// Step 2
		Session session = sessionFactory.openSession();
		// Step 3
		session.beginTransaction();
		// Step 4
//		if cascade is not used we have to save each object separately
		// session.save(user);
		// session.save(vehicle);
		// session.save(mobile1);
		// session.save(mobile2);
		// session.save(pen1);
		// session.save(pen2);
		// session.save(pos1);
		// session.save(pos2);

		// session.persist is used to do cascade CRUD operations
		session.persist(user);
		session.save(bike);
		session.save(car);
		session.save(ballPen);
		session.save(fountainPen);
		session.save(keyPadMobile);
		session.save(touchScreenMobile);
		session.persist(user2);
		// Step 5
		session.getTransaction().commit();
		// Step 6
		session.close();

		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		System.out.println("User Name Retrieved is : " + user.getName());
		System.out.println("User Address List : " + user.getSetOfAddress());
		session.disconnect();
		session.close();
	}

}
