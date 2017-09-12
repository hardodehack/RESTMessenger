package xyz.hardik.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;


import xyz.hardik.RESTMessenger.database.Database;
import xyz.hardik.RESTMessenger.model.Message;

public class DateTester {
	
	public static void main(String[] args) {
	
		Map<Long,Message> dateTestMap = Database.getMessages();
		
		dateTestMap.put(1L,new Message(1L,"M1","Hardik"));
		
		Date d = dateTestMap.get(1L).getDate();
		
		System.out.println(d);
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(dateTestMap.get(1L).getDate());
		
		System.out.println(cal.get(Calendar.YEAR));
		
		for(Message message:dateTestMap.values()) {
			cal.setTime(message.getDate());
	}
	
	
	
	}
	
	
	
	

}
