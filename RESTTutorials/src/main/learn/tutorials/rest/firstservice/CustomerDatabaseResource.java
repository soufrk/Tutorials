package learn.tutorials.rest.firstservice;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/customers")
public class CustomerDatabaseResource {
	
	protected static final CustomerResource europe = new CustomerResource();
	protected static final FirstLastCustomerResource northamerica = new FirstLastCustomerResource();
	
	@Path("{database}-db")
	public Object getDatabase(@PathParam("database") String db){
		Object resource = locateDB(db);
		return resource;
	}
	
	protected Object locateDB(String db){
		if(db.equalsIgnoreCase("europe"))
			return europe;
		else if(db.equalsIgnoreCase("northamerica"))
			return northamerica;
		else
			throw new WebApplicationException(Response.Status.NOT_FOUND);
	}
}
