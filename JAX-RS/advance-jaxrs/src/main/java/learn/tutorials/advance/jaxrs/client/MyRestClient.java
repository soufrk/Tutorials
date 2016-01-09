package learn.tutorials.advance.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import learn.tutorials.jaxrs.messenger.model.Message;

public class MyRestClient {
	public static void main(String[] args) {
//------------------------------------------------------------------------------------------------		
		// Create a client using client builder
		Client client = ClientBuilder.newClient();
//------------------------------------------------------------------------------------------------
		//GET METHOD
//************************************************************************************************
		// set the target url to the client to make a call to
		WebTarget target = client.target("http://localhost:8080/messenger/webapi/messages/1");
		// build a request
		Builder builder = target.request(MediaType.TEXT_XML);
		// make a get/post call to get the response
		Response response = builder.get();
		Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());
//************************************************************************************************
		// Another approach
		Message message3 = client.target("http://localhost:8080/messenger/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON).get(Message.class);
		System.out.println(message3.getMessage());
//************************************************************************************************
		// Above written code is not good we should follow some best practices
		// as follows
		// Set the base target first
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi");
		// Set the resource path
		WebTarget messageTarget = baseTarget.path("messages");
		// Set a placeholder to the path
		WebTarget singleMessage = messageTarget.path("{messageId}");

		Message message1 = singleMessage.resolveTemplate("messageId", "1").request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		Message message2 = singleMessage.resolveTemplate("messageId", "2").request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());
//************************************************************************************************
		//POST METHOD
//************************************************************************************************
		Message message4 = new Message(6, "Saurabh kedia", "Heisenberg");
		Response postResponse = messageTarget.request().post(Entity.json(message4));
		System.out.println(postResponse);
//************************************************************************************************
	}
}
