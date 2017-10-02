package xyz.hardik.RESTMessenger.model.messageBean;

import javax.ws.rs.PathParam;

public class MessageFilterBeanClass {
	
	@PathParam("messageId") long messageId;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

}
