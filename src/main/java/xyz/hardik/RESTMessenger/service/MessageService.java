package xyz.hardik.RESTMessenger.service;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> listMessForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()) {
			cal.setTime(message.getDate());
			if(cal.get(Calendar.YEAR)==year) {
				listMessForYear.add(message);
				}
		}
		return listMessForYear;
	}
	
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		List<Message> paginatedMessages = new ArrayList<Message>(messages.values());
		
		if(start+size > paginatedMessages.size()) return new ArrayList<Message>();
		
		return paginatedMessages.subList(start, start + size);
		
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