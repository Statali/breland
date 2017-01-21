package org.server.localshop.services;


import org.server.localshop.domain.Response;
import org.server.localshop.domain.User;
import org.server.localshop.repositoryclasses.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	private final UserRepository  userRepository;


	@Autowired
	public UsersService( final UserRepository  userRepository){
		this.userRepository = userRepository;
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
					user = this.userRepository.save(user);
					result.setObject(user);
				}
			}
		}
		return result;
	}


	public User updateUser( User user){
		Response<User> result = new Response<User>();
		if (!this.userRepository.exists(user.getId())) {
			result.getException().add((new IllegalArgumentException("user.with.id.noexist")));
		}
		else{
			user = this.userRepository.saveAndFlush(user);
		}
		return user;
	}


}
