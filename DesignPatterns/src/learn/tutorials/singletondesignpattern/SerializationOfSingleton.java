package learn.tutorials.singletondesignpattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Demo of how deserializing a serializable singleton creates a new object
 * 
 * @author saurabh.kedia
 *
 */
public class SerializationOfSingleton {

	public static void main(String[] args) {
		//Get the instance and set the instance variable
		SerializableSingletonClass instance1 = SerializableSingletonClass.getInstance();
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
				"D:/SingletonSerialization.txt"))) {
			out.writeObject(instance1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Instance 1 : " + instance1.hashCode());
		SerializableSingletonClass instance2 = null;
		try(ObjectInput in = new ObjectInputStream(new FileInputStream(new File("D:/SingletonSerialization.txt")))){
			instance2 = (SerializableSingletonClass) in.readObject();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Instance 2 : " + instance2.hashCode());
		
		//Preventing above scenario by providing readResolve method in serializable singleton
		SerializableSingleton instance3 = SerializableSingleton.getInstance();
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
				"D:/SingletonSerialization2.txt"))) {
			out.writeObject(instance3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SerializableSingleton instance4 = null;
		System.out.println("Instance 3 : " + instance3.hashCode());
		try(ObjectInput in = new ObjectInputStream(new FileInputStream(new File("D:/SingletonSerialization2.txt")))){
			instance4 = (SerializableSingleton) in.readObject();
		} catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Instance 4 : " + instance4.hashCode());
	}
}

class SerializableSingletonClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8415862486757901100L;

	private static SerializableSingletonClass singleton = new SerializableSingletonClass();
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SerializableSingletonClass() {
	}

	/**
	 * Method to return the single instance created for this class which
	 * internally calls the private static class to get the INSTANCE, no
	 * synchronization is required and it eill be called only once when the
	 * first call is made
	 * 
	 * @return SingletonClassLI1
	 */

	public static SerializableSingletonClass getInstance() {
		return singleton;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}

class SerializableSingleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8415862486757901100L;

	private static SerializableSingleton singleton = new SerializableSingleton();
	private String stringVariable;

	/**
	 * Private constructor to restrict others from creating new objects of this
	 * class
	 */
	private SerializableSingleton() {
	}

	/**
	 * Method to return the single instance created for this class which
	 * internally calls the private static class to get the INSTANCE, no
	 * synchronization is required and it eill be called only once when the
	 * first call is made
	 * 
	 * @return SingletonClassLI1
	 */

	public static SerializableSingleton getInstance() {
		return singleton;
	}
	
	protected Object readResolve(){
		return getInstance();
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public void setStringVariable(String stringVariable) {
		this.stringVariable = stringVariable;
	}
}