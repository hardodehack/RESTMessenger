package xyz.hardik.RESTMessenger.exception;

import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Data Not Found for Requested Type...";
	}
}
