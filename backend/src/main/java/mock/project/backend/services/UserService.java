package mock.project.backend.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import mock.project.backend.entities.UserRole;
import mock.project.backend.entities.Users;
import mock.project.backend.repository.UserRepository;
import mock.project.backend.repository.UserRoleRepository;
import mock.project.backend.request.UserDTO;
import mock.project.backend.request.UserDTOReponse;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Autowired
	private ModelMapper modelMap;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	public Users checkLogin(final Users user) {
//		return userRepo.findByUserNameAndPassword(user.getUserName(), user.getEncryptedPassword());
//	}
		
	public Users registerUserAccount(UserDTO userDTO) throws Exception {
		Users user = new Users();
		user.setUserName(userDTO.getUserName());
		user.setEncryptedPassword((bCryptPasswordEncoder.encode(userDTO.getPassword())));;
		user.setFullName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setAddress(userDTO.getAddress());
		user.setPhone(userDTO.getPhone());
		user.setDateofBirth(userDTO.getDateofBirth());
		user.setImage(userDTO.getImage());
		user.setEnabled(true);
		userRepo.save(user);
		userRoleRepo.save(new UserRole(user,userDTO.getRole()));
		return user;
	}
	
	public UserDTOReponse findByUserName(String userName) {
		UserDTOReponse userDTO = modelMap.map(userRepo.findByUserName(userName), UserDTOReponse.class);
		return userDTO;
	}

}
