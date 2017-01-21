package org.server.localshop.repositoryclasses;

import org.server.localshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User>{
	
	public User findByEmail(@Param("email") String email);
	public User findByPhone(@Param("phone") String phone);

}
