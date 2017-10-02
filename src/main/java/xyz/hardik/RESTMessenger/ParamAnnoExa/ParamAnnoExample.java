package xyz.hardik.RESTMessenger.ParamAnnoExa;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("paramAnno")
public class ParamAnnoExample {

	@GET
	@Path("matrixParam")
	@Produces(MediaType.TEXT_PLAIN)
	public String matrixParam(@MatrixParam("matParam")String matParam) {
		return matParam;
	}
	
	@POST
	@Path("Authentication")
	@Produces(MediaType.TEXT_PLAIN)
	public String headerParam(@HeaderParam("oAuth")String oAuth) {
		return oAuth;
	}
	
	@GET
	@Path("cookieParam")
	@Produces(MediaType.TEXT_PLAIN)
	public String cookieParam(@CookieParam("cname")Cookie cname){
		return cname.getValue();
	}
	
	@GET
	@Path("context")
	public String contextParam(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String absPath = uriInfo.getAbsolutePath().toString();
		String cookiesAll = headers.getCookies().toString();
		return absPath + "\n" + cookiesAll;
	}

}
