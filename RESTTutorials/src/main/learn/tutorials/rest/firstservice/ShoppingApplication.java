package learn.tutorials.rest.firstservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ShoppingApplication extends Application{
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> empty = new HashSet<>();
	
	public ShoppingApplication(){
		singletons.add(new CustomerDatabaseResource());
	}
	
	@Override
	public Set<Class<?>> getClasses(){
		return empty;
	}
	
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}
}
