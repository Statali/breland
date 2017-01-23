package org.server.localshop.services;


import org.server.localshop.domain.Response;
import org.server.localshop.domain.User;
import org.server.localshop.repositoryclasses.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	private final UserRepository  userRepository;
	private final DateTime dateTime;
	


	@Autowired
	public UsersService( final UserRepository  userRepository, final DateTime dateTime){
		this.userRepository = userRepository;
		this.dateTime = dateTime;
	}	


	public Response<User>  createUser(User user){
		Response<User> result = new Response<User>();
		if (user.getId() != null ) {
			result.getException().add((new IllegalArgumentException("user.with.id.exist")));
		}
		else{
			if(this.userRepository.findByEmail(user.getEmail()) != null) {
				result.getException().add((new IllegalArgumentException("user.with.email.exist")));
			}
			else{
				if(this.userRepository.findByPhone(user.getPhone()) == null) {
					result.getException().add((new IllegalArgumentException("user.with.phone.exist")));
				}
				else{
					user.setCreatedDate(this.dateTime.getCurrentDateTime());
					user.setUpdatedDate(this.dateTime.getCurrentDateTime());
					user = this.userRepository.save(user);
					result.setObject(user);
				}
			}
		}
		return result;
	}


	public Response<User> updateUser( User user){
		Response<User> result = new Response<User>();
		if (!this.userRepository.exists(user.getId())) {
			result.getException().add((new IllegalArgumentException("user.with.id.noexist")));
		}
		else{
			user.setUpdatedDate(this.dateTime.getCurrentDateTime());			
			user = this.userRepository.save(user);
			result.setObject(user);
		}
		return result;
	}


}
