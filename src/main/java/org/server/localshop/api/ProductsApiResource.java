package org.server.localshop.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.util.json.JSONObject;

@Component	
@Path("/products")
public class ProductsApiResource {
	
	@Autowired
	


	

	@POST
	public String createProduct(){
	
		return null;
	}
}
