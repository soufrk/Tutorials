package learn.tutorials.jaxrs.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String param,
			@HeaderParam("customValue") String customValue,
			@CookieParam("name") String cookie){
		String result = "Matrix Param : " + param;
		result += "\nHeader Param : " + customValue;
		result += "\nCookie Param : " + cookie;
		return result;
	}
	
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
		String result = "Uri Info : " + uriInfo.toString();
		result += "\nURI path : " + uriInfo.getPath();
		result += "\nHttpHeader : " + httpHeaders.toString();
		return result;
	}
}
