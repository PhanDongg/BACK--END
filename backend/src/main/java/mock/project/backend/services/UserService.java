package mock.project.backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mock.project.backend.entities.Users;
import mock.project.backend.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
//	   @PersistenceContext
//
//       private EntityManager entityManager;
	
	public Users checkLogin(final Users user) {
		return userRepo.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	}

}
