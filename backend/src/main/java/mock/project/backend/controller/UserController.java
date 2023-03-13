package mock.project.backend.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mock.project.backend.entities.Users;
import mock.project.backend.request.UserDTO;
import mock.project.backend.request.UserDTOReponse;
import mock.project.backend.response.ResponseTransfer;
import mock.project.backend.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
//	@PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseTransfer checkLogin(@RequestBody Users user) {
//		logger.info("Checking idenityyy.......");
//		Users userData = userService.checkLogin(user);
//		if(userData !=null) {
//			return new ResponseTransfer("Login Successful!");
//		}
//		return new ResponseTransfer("Login Fail!");
//	}
	
	@PostMapping(value="/register-user", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users save(@RequestBody UserDTO user) throws Exception {
		return userService.registerUserAccount(user);
	}
	
	@PostMapping(value="/userInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTOReponse getInfoByUserName(@RequestParam(value="username" ,required = false)String username) throws Exception {
		logger.info("Searching user by username...");
		return userService.findByUserName(username);
	}
	
	
}
