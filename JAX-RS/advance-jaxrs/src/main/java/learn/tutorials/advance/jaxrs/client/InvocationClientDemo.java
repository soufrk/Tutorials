package learn.tutorials.advance.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationClientDemo {
	public static void main(String[] args){
		// Build a request
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi");
		// Set the resource path
		WebTarget messageTarget = baseTarget.path("messages");
		// Set a placeholder to the path
		WebTarget singleMessage = messageTarget.path("{messageId}");
		//Instead of making a get request we build a get request which is then handed over to somebody else
		Invocation invocation = singleMessage.resolveTemplate("messageId", "1").request(MediaType.APPLICATION_JSON)
				.buildGet();
		
		//Execute the request
		Response response = invocation.invoke();
		System.out.println(response);
	}
}
