package xyz.hardik.RESTMessenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import xyz.hardik.RESTMessenger.exception.DataNotFoundException;
import xyz.hardik.RESTMessenger.exception.DataNotFoundExceptionMapper;
import xyz.hardik.RESTMessenger.model.*;
import xyz.hardik.RESTMessenger.model.messageBean.MessageFilterBeanClass;
import xyz.hardik.RESTMessenger.service.MessageService;


@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	

	@GET
	public List<Message> getMessages(	/*@QueryParam("year") int year,
										@QueryParam("start") int start,
										@QueryParam("size") int size*/) {
		/*if(year>0) {
			return messageService.getAllMessagesForYear(year);
		}
		if(size >= 0 && start >= 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}*/
		return messageService.getAllMessages();
	}
	
	
	
	@Path("/{messageId}")
	@GET()
	public Message getMessage(@PathParam("messageId") long messageId) {
		Message msg = messageService.getMessage(messageId);
		
		Response response = Response.status(707).build();
		
		if(msg == null) {
			throw new WebApplicationException(response);
			// throw new DataNotFoundException;
			// throw new NotFoundException;
		}
		return msg;
	}
	
	
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo, @Context HttpHeaders header) {
		Message newMessage =  messageService.addMessage(message);
		
		String newId = String.valueOf(newMessage.getId());
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		
		/*
		 * 
		 * Some Useful Methods of HttpHeader and UriInfo Class.
		 * 
		String cTypeTest = header.getRequestHeader("Content-Type").get(0);
		System.out.println(cTypeTest);
		
		System.out.println("All avaliable Headers");
		for(String h : header.getRequestHeaders().keySet()) {
			System.out.println(h);
		}
		
		Response.status(Status.ACCEPTED).build();
		*/
		
		return Response.created(uri).entity(message).build();
	}
	
	
	/*@Path(("/{messageId}"))
	@PUT
	public Message updateMessage(@BeanParam MessageFilterBeanClass msgBean) {
		message.setId(msgBean.getMessageId());
		return messageService.updateMessage(message);
	}*/

	
	@Path("/{messageId}")
	@DELETE
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.deleteMessage(messageId);
	}
	
}
