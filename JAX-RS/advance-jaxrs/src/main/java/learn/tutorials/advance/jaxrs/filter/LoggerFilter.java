package learn.tutorials.advance.jaxrs.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LoggerFilter implements ContainerRequestFilter, ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Response Headers : " + responseContext.getHeaders().toString());
		
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Request Headers : " + requestContext.getHeaders().toString());
	}

}
