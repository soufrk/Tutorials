package learn.tutorials.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import learn.tutorials.jaxrs.messenger.database.DatabaseStub;
import learn.tutorials.jaxrs.messenger.model.Message;

public class MessageService {

	private Map<Integer, Message> messages = DatabaseStub.getMessages();

	public MessageService() {
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messageListForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year)
				messageListForYear.add(message);
		}
		return messageListForYear;
	}

	public List<Message> getMessagesPaginated(int start, int size) {
		return new ArrayList<>(messages.values()).subList(start, start + size);
	}

	public Message getMessage(int id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() == 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message deleteMessage(int id) {
		return messages.remove(id);
	}
}
