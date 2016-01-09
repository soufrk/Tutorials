package learn.tutorials.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import learn.tutorials.jaxrs.messenger.database.DatabaseStub;
import learn.tutorials.jaxrs.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseStub.getProfiles();

	public ProfileService() {
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName() == null || profile.getProfileName().equals("")) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
