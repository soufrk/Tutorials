package learn.tutorials.advance.jaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("secured")
public class MyResourceBasicAuth {
	
	@GET
	public String LogIn(){
		return "Successfully Logged In";
	}
}
