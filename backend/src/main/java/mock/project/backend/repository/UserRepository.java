package mock.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mock.project.backend.entities.Users;

@Repository(value="userRepo")
public interface UserRepository  extends JpaRepository<Users, Integer>{
	
//	Users findByUserNameAndPassword(String userName, String password);
	Users findByUserName(String userName);
}