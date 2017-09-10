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
import xyz.hardik.RESTMessenger.service.ProfileService;


@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {		
		return (new ProfileService().getAllProfiles());
	}
	
	
	@Path("/{profileName}")
	@GET()
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	
	@Path(("/{profileName}"))
	@PUT
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	
	@Path("/{profileName}")
	@DELETE
	public Profile deleteMessage(@PathParam("profileName") String profileName) {
		return profileService.deleteProfile(profileName);
	}
	
}
