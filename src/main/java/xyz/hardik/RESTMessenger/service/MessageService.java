package xyz.hardik.RESTMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xyz.hardik.RESTMessenger.database.Database;
import xyz.hardik.RESTMessenger.model.*;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message msg) {
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		if(msg.getId()<=0)
			return null;
		
		messages.put(msg.getId(),msg);
		
		return msg;
	}
	
	
	public Message deleteMessage(long id) {
		messages.remove(id);
		return messages.get(id);
	}

}