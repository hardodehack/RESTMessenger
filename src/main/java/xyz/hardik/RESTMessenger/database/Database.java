package xyz.hardik.RESTMessenger.database;

import java.util.HashMap;
import java.util.Map;

import xyz.hardik.RESTMessenger.model.Message;
import xyz.hardik.RESTMessenger.model.Profile;

/*
 * This is Database Stub b'coz we don't want to use R-Databses Here.
 * The Data will be stored here unless and untill server not restarted.
 * This is Not Thread Safe.
 * 
 */

public class Database {
	
	public static Map<Long,Message> messages = new HashMap<Long, Message>();
	public static Map<String,Profile> profiles = new HashMap<String, Profile>();

	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
}