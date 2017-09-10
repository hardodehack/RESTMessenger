package xyz.hardik.RESTMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xyz.hardik.RESTMessenger.database.Database;
import xyz.hardik.RESTMessenger.model.*;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService() {
		profiles.put("Hardik",new Profile(1,"hardik","Hardik","Patel"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name) {
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
			return null;
		
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	
	public Profile deleteProfile(String profileName) {
		profiles.remove(profileName);
		return profiles.get(profileName);
	}

}