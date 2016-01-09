package learn.tutorials.advance.jaxrs.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_KEY_NAME = "Authorization";
	private static final String AUTHORIZATION_BASIC_PREFIX = "Basic ";
	private static final String SECURED_URL = "secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_KEY_NAME);
		if (requestContext.getUriInfo().getAbsolutePath().getPath().contains(SECURED_URL)
				&& authHeader != null 
				&& authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replace(AUTHORIZATION_BASIC_PREFIX, "");
			String authTokenDecoded = Base64.decodeAsString(authToken.getBytes("UTF-8"));
			StringTokenizer tokenizer = new StringTokenizer(authTokenDecoded, ":");
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			if (userName.equalsIgnoreCase("user") && password.equalsIgnoreCase("password"))
				return;

		}

		Response unauthorizedStatus = Response
				.status(Response.Status.UNAUTHORIZED)
				.entity("User cannot Access the resource")
				.build();
		requestContext.abortWith(unauthorizedStatus);
	}

}
