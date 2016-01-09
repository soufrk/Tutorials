package learn.tutorials.advance.jaxrs.resource;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("readwrite")
public class MyResourceMessageBodyReaderWriter {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getDate(){
		return new Date();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Date setDate(Date date){
		return date;
	}
}
