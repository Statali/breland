package org.server.localshop.api;

import org.server.localshop.domain.Response;
import org.server.localshop.domain.User;
import org.server.localshop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersApiResource {	
		
	private final UsersService usersService;

	@Autowired
	public UsersApiResource(final UsersService usersService){
		this.usersService = usersService;
	}	
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		return "TEEEEEEEEE..............";
	}
	
	@ResponseBody
	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public Response<User> registerUser(@RequestBody User user){
		return this.usersService.createUser(user);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/users/", method = RequestMethod.PUT)
    public Response<User> updateUser(@RequestBody User user) {
		return this.usersService.updateUser(user);
	}
	
	

}
