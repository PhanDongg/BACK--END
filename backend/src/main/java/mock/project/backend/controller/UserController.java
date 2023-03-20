package mock.project.backend.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mock.project.backend.entities.Users;
import mock.project.backend.request.OrderDTO;
import mock.project.backend.request.UserDTO;
import mock.project.backend.request.UserDTOReponse;
import mock.project.backend.response.ResponseTransfer;
import mock.project.backend.services.OrderService;
import mock.project.backend.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	//register new user
	@PostMapping(value="/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseTransfer save(@RequestBody UserDTO user) throws Exception {
		Users newUser = userService.registerUserAccount(user);
		if(newUser == null) {
			return new ResponseTransfer("Something went wrong");		
			}
		return new ResponseTransfer("Register successful");	
	}
	
	//get userInfo
	@PostMapping(value="/userInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTOReponse getInfoByUserName(@RequestParam(value="username" ,required = false)String username) throws Exception {
		logger.info("Searching user by username...");
		return userService.findByUserName(username);
	}
	
	//get list order of user
	@GetMapping(value="/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getOrderByUserID(@RequestParam(value="userId",required = false)Integer userId) throws Exception {
		logger.info("Searching order by id...");
		return orderService.findListOrdersByUserId(userId);
	}
	
	
}

