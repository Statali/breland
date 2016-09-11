package org.server.localshop.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.server.localshop.services.SellersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

@Component
@Path("/seller")
public class SellerApiResource {

	private final SellersService sellerService;
	
	@Autowired
	public SellerApiResource(final SellersService sellerService){
		this.sellerService = sellerService;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.WILDCARD)
	public String test(){
		
		return "fgfdgdfg";
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addSeller(String jSonParams){
		JSONObject result = new JSONObject();
		try {
			result.put("result", (long) this.sellerService.createSeller(jSonParams)) ;
		} catch (JSONException e) {
			e.printStackTrace();
			result = null;
		}
		return result.toString();
	}
	
	
	
}
