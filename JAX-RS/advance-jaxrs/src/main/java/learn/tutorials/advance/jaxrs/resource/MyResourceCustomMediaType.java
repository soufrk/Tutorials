package learn.tutorials.advance.jaxrs.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("media")
public class MyResourceCustomMediaType {

	@GET
	@Produces("application/shortdate")
	public Date getShortDate(){
		return new Date();
	}
}
