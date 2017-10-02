/*package xyz.hardik.RESTMessenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptoinMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {

		String wrong = "Ahhhaa.. Something Went Wrong,, Maybe Your Side or Our Side....";
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(wrong).build();
		
	}
	
	

}
*/