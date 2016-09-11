package org.server.localshop.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.server.localshop.services.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/place")
public class PlaceApiResource {


	final PlacesService placeServ;

	@Autowired
	public PlaceApiResource(final PlacesService placeServ){
		this.placeServ = placeServ;
	}



	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void createPlace(String params){
		//return this.placeServ.createPlace(params);
	}


	@GET
	public Long getPlace(String params){
		return (long) 5;
	}

}
