package learn.tutorials.jaxrs.messenger.database;

import java.util.HashMap;
import java.util.Map;

import learn.tutorials.jaxrs.messenger.model.Message;
import learn.tutorials.jaxrs.messenger.model.Profile;

public class DatabaseStub {

	private static final Map<Integer, Message> messages = new HashMap<>();
	private static final Map<String, Profile> profiles = new HashMap<>();

	public static Map<Integer, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}