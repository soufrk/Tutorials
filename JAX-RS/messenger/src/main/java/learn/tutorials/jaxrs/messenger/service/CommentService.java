package learn.tutorials.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import learn.tutorials.jaxrs.messenger.database.DatabaseStub;
import learn.tutorials.jaxrs.messenger.model.Comment;
import learn.tutorials.jaxrs.messenger.model.ErrorMessage;
import learn.tutorials.jaxrs.messenger.model.Message;

public class CommentService {
	private Map<Integer, Message> messages = DatabaseStub.getMessages();

	public CommentService() {
	}

	public List<Comment> getAllComments(int messageId) {
		return new ArrayList<>(messages.get(messageId).getComments().values());
	}

	public Comment getComment(int messageId, int commentId) {
		Message message = messages.get(messageId);
		ErrorMessage errorMessage = new ErrorMessage("Resource not found", 404, "http://www.kdtechworld.blogspot.com");
		Response response = Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		if(message == null)
			throw new WebApplicationException(response);
		Comment comment = message.getComments().get(commentId);
		if(comment == null)
			throw new NotFoundException(response);
		return comment;
	}

	public Comment addComment(int messageId, Comment comment) {
		comment.setId(messages.get(messageId).getComments().size() + 1);
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(int messageId, Comment comment) {
		if (comment.getId() == 0) {
			return null;
		}
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;
	}

	public Comment deleteComment(int messageId, int commentId) {
		return messages.get(messageId).getComments().remove(commentId);
	}
}
