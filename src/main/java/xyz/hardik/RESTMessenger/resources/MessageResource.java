package xyz.hardik.RESTMessenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import xyz.hardik.RESTMessenger.model.*;
import xyz.hardik.RESTMessenger.service.MessageService;


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages() {		
		return (new MessageService().getAllMessages());
	}
	
	
	@Path("/{messageId}")
	@GET()
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}
	
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	
	@Path(("/{messageId}"))
	@PUT
	public Message updateMessage(@PathParam("messageId") long messageId,Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	
	@Path("/{messageId}")
	@DELETE
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.deleteMessage(messageId);
	}
	
}
